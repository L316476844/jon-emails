package org.jon.lv.email.domain;


import org.jon.lv.verify.ValidateHelper;

import java.io.Serializable;
import java.util.Map;

/**
 * @Description: Email
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/10 10:39
 * version V1.0.0
 */
public class Email implements Serializable{
    private static final long serialVersionUID = 6526007513511751821L;

    /**
     * 收件人邮箱
     */
    private String[] toEmails;

    /**
     * 抄送邮箱
     */
    private String[] ccEmails;

    /**
     * 密送邮箱
     */
    private String[] bccEmails;

    /**
     * 邮件主题
     */
    private String subject;

    /**
     * 邮件内容--富文本
     */
    private String htmlContent;

    /**
     * 附件
     */
    private MailAttach[] attachments;

    /**
     * 编码方式
     * @return
     */
    private String Encoding = "UTF-8";

    public String[] getToEmails() {
        return toEmails;
    }

    public void setToEmails(String[] toEmails) {
        this.toEmails = toEmails;
    }

    public String[] getCcEmails() {
        return ccEmails;
    }

    public void setCcEmails(String[] ccEmails) {
        this.ccEmails = ccEmails;
    }

    public String[] getBccEmails() {
        return bccEmails;
    }

    public void setBccEmails(String[] bccEmails) {
        this.bccEmails = bccEmails;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public MailAttach[] getAttachments() {
        return attachments;
    }

    public void setAttachments(MailAttach[] attachments) {
        this.attachments = attachments;
    }

    public String getEncoding() {
        return Encoding;
    }

    public void setEncoding(String encoding) {
        Encoding = encoding;
    }

    /**
     * 校验参数
     * @return
     */
    public String verifyEmail(){
        if(ValidateHelper.isEmpty(this.toEmails)){
            return "收件人不能为空";
        }
        if(ValidateHelper.isEmpty(this.subject)){
            return "邮件主题不能为空";
        }
        if(ValidateHelper.isEmpty(this.htmlContent)){
            return "邮件内容不能为空";
        }

        return null;
    }
}
