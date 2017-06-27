package org.jon.lv.email.service.impl;

import com.alibaba.fastjson.JSON;
import com.sun.mail.util.MailSSLSocketFactory;
import org.jon.lv.email.domain.Email;
import org.jon.lv.email.domain.MailAttach;
import org.jon.lv.email.domain.MailConfig;
import org.jon.lv.email.service.EmailService;
import org.jon.lv.result.ResultDO;
import org.jon.lv.verify.ValidateHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.activation.URLDataSource;
import javax.mail.internet.MimeMessage;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * @Description: EmailService 可使用spring xml声明亦可以通过工厂方式调用
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/10 11:14
 * version V1.0.0
 */
public class EmailServiceImpl implements EmailService {

    private JavaMailSenderImpl javaMailSender;
    /** 是否认证 **/
    private String mailSmtpAuth;
    /** 超时时间 **/
    private String mailSmtpTimeout;
    /** 发件人地址 **/
    private String mailFrom;

    @Override
    public ResultDO<Boolean> sendEmail(Email email) {
        ResultDO<Boolean> resultDO = new ResultDO<>();
        String error = sendMail(javaMailSender, email, mailFrom);
        if(error != null){
            resultDO.setErrMsg(error);
            return resultDO;
        }
        resultDO.setSuccess(true);

        return resultDO;
    }

    @Override
    public ResultDO<Boolean> sendEmail(MailConfig mailConfig, Email email) {
        ResultDO<Boolean> resultDO = new ResultDO<>();
        String verifyEmail = email.verifyEmail();
        if (verifyEmail != null) {
            resultDO.setErrMsg(verifyEmail);
            return resultDO;
        }
        JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
        senderImpl.setHost(mailConfig.getEmailHost());
        senderImpl.setUsername(mailConfig.getEmailUserName());
        senderImpl.setPassword(mailConfig.getEmailPassword());

        String error = sendMail(senderImpl, email, mailConfig.getEmailFrom());
        if(error != null){
            resultDO.setErrMsg(error);
            return resultDO;
        }
        resultDO.setSuccess(true);
        return resultDO;
    }

    private String sendMail(JavaMailSenderImpl javaMailSender, Email email, String fromMail){
        MimeMessage mailMessage = javaMailSender.createMimeMessage();
        try {

            Properties prop = new Properties();
            prop.put("mail.smtp.auth", mailSmtpAuth); // 设为true，服务器进行认证
            prop.put("mail.smtp.timeout", mailSmtpTimeout);
            if(fromMail.endsWith("qq.com")){
                // qq 服务器需要ssl
                try {
                    MailSSLSocketFactory sf = new MailSSLSocketFactory();
                    sf.setTrustAllHosts(true);
                    prop.put("mail.smtp.ssl.enable", "true");
                    prop.put("mail.smtp.ssl.socketFactory", sf);
                } catch (GeneralSecurityException e) {
                }
            }
            javaMailSender.setJavaMailProperties(prop);

            MimeMessageHelper  messageHelper = new MimeMessageHelper(mailMessage, true, email.getEncoding());
            messageHelper.setFrom(fromMail);
            messageHelper.setTo(email.getToEmails());
            if(!ValidateHelper.isEmpty(email.getCcEmails())){
                messageHelper.setCc(email.getCcEmails());
            }
            if(!ValidateHelper.isEmpty(email.getBccEmails())){
                messageHelper.setBcc(email.getBccEmails());
            }
            messageHelper.setSubject(email.getSubject());
            // true 表示启动HTML格式的邮件
            messageHelper.setText(email.getHtmlContent(), true);
            if(!ValidateHelper.isEmpty(email.getAttachments())){
                for(MailAttach attach: email.getAttachments()){
                    try {
                        URLDataSource url = new URLDataSource(new URL(attach.getPath()));
                        messageHelper.addAttachment(attach.getName(), url);
                    } catch (MalformedURLException e) {
                        return e.getMessage();
                    }
                }
            }

            javaMailSender.send(mailMessage);
        } catch (Exception e) {
            return e.getMessage();
        }

        return null;
    }

    public JavaMailSenderImpl getJavaMailSender() {
        return javaMailSender;
    }

    public void setJavaMailSender(JavaMailSenderImpl javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public String getMailFrom() {
        return mailFrom;
    }

    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }

    public String getMailSmtpTimeout() {
        return mailSmtpTimeout;
    }

    public void setMailSmtpTimeout(String mailSmtpTimeout) {
        this.mailSmtpTimeout = mailSmtpTimeout;
    }

    public String getMailSmtpAuth() {
        return mailSmtpAuth;
    }

    public void setMailSmtpAuth(String mailSmtpAuth) {
        this.mailSmtpAuth = mailSmtpAuth;
    }
}
