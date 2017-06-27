package org.jon.lv.email;

import org.apache.log4j.Logger;
import org.jon.lv.email.service.EmailService;
import org.jon.lv.email.service.impl.EmailServiceImpl;
import org.jon.lv.email.utils.LoaderUtils;
import org.jon.lv.email.utils.MailEnvironment;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * @Package org.jon.lv.email.EmailServiceFactory
 * @Description: Email
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/6/27 10:24
 * version V1.0.0
 */
public class EmailServiceFactory {
    private static final Logger LOGGER = Logger.getLogger(EmailServiceFactory.class);

    // 单例
    public static EmailService getInstance(){
        return EmailServiceFactory.EmailServiceFactoryHold.INSTANCE;
    }

    private static class EmailServiceFactoryHold{
        private static final EmailServiceImpl INSTANCE = new EmailServiceImpl();

        private EmailServiceFactoryHold() {
        }

        static {
            /**
             * 首先加载classpath下的mail-env.properties配置文件，
             * 加载失败则加载工具包内的配置文件
             */
            Properties properties = new Properties();
            URL url = ClassLoader.getSystemResource(MailEnvironment.DEFAULT_CONFIGURATION_FILE);

            if(url == null){
                LOGGER.warn("Please add the email configuration file to class path");
                url = LoaderUtils.getResource(MailEnvironment.DEFAULT_CONFIGURATION_FILE);
            }

            try {
                properties.load(new FileInputStream(url.getFile()));
            } catch (IOException e) {
                LOGGER.error("Caught Exception while in Loader.get properties.", e);
            }

            JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
            javaMailSender.setDefaultEncoding("UTF-8");
            javaMailSender.setHost(properties.getProperty(MailEnvironment.MAIL_HOST));
            javaMailSender.setUsername(properties.getProperty(MailEnvironment.MAIL_USER));
            javaMailSender.setPassword(properties.getProperty(MailEnvironment.MAIL_PWD));

            INSTANCE.setJavaMailSender(javaMailSender);
            INSTANCE.setMailFrom(properties.getProperty(MailEnvironment.MAIL_FROM));
            INSTANCE.setMailSmtpAuth(properties.getProperty(MailEnvironment.MAIL_SMTP_AUTH));
            INSTANCE.setMailSmtpTimeout(properties.getProperty(MailEnvironment.MAIL_SMTP_TIMEOUT));
        }
    }
}
