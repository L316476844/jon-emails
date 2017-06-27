package org.jon.lv.email;

import org.jon.lv.email.domain.Email;
import org.jon.lv.email.domain.MailAttach;
import org.jon.lv.email.domain.MailConfig;
import org.jon.lv.email.service.EmailService;
import org.junit.Test;

/**
 * @Description: EmailService
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/10 13:48
 * version V1.0.0
 */
public class EmailServiceTest {
    private EmailService emailService = EmailServiceFactory.getInstance();

    @Test
    public void testSendEmail(){
        Email email = new Email();
        email.setToEmails(new String[]{"316476844@qq.com"});
        email.setCcEmails(new String[]{"316476844@qq.com"});
        email.setBccEmails(new String[]{"598942480@qq.com"});
        email.setSubject("邮件服务测试");
        email.setHtmlContent("\" <p style=\\\"text-align: left;\\\">\\n\" +\n" +
                "                \"     尽管房地产低迷，但没有影响到房地产税相关政策的出台。尽管中国房地产业协会副会长任志强近日表示：“房地产税和房价没关系”。但是买房的朋友依然非常关注相应税收的情况，究竟征收的标准是什么，税该如何计算?<br/>\\n\" +\n" +
                "                \" </p>\\n\" +\n" +
                "                \" <p style=\\\"text-align: left;\\\">\\n\" +\n" +
                "                \"     &nbsp;&nbsp;\\n\" +\n" +
                "                \" </p>\\n\" +\n" +
                "                \" <p style=\\\"text-align: left;\\\">\\n\" +\n" +
                "                \"     房产税征收标准及税收如何计算\\n\" +\n" +
                "                \" </p>\\n\" +\n");
        email.setAttachments(new MailAttach[]{
                new MailAttach("red.jpg", "http://hi.csdn.net/attachment/201012/29/8394323_1293613306CGzE.jpg"),
                new MailAttach("black.jpg", "http://hi.csdn.net/attachment/201012/29/8394323_1293614183gD0H.jpg")});
        emailService.sendEmail(email);
    }

    @Test
    public void testSendEmailAndConfig(){
        MailConfig mailConfig = new MailConfig();
        mailConfig.setEmailHost("smtp.qq.com");
        mailConfig.setEmailUserName("316476844@qq.com");
        mailConfig.setEmailPassword("sdhkjsdhkhsdjdf");
        mailConfig.setEmailFrom("316476844@qq.com");

        Email email = new Email();
        email.setToEmails(new String[]{"lvbin@oriental-finance.com"});
        email.setSubject("127982179邮件服务测试");
        email.setHtmlContent("<p style=\\\"text-align: left;\\\">\\n\" +\n" +
                "                \"     尽管房地产低迷，但没有影响到房地产税相关政策的出台。尽管中国房地产业协会副会长任志强近日表示：“房地产税和房价没关系”。但是买房的朋友依然非常关注相应税收的情况，究竟征收的标准是什么，税该如何计算?<br/>\\n\" +\n" +
                "                \" <p style=\\\"text-align: left;\\\">\\n\" +\n" +
                "                \"     房产税征收标准及税收如何计算\\n\" +\n" +
                "                \" </p>\\n\" +\n");
        email.setAttachments(new MailAttach[]{
                new MailAttach("red.jpg", "http://hi.csdn.net/attachment/201012/29/8394323_1293613306CGzE.jpg"),
                new MailAttach("black.jpg", "http://hi.csdn.net/attachment/201012/29/8394323_1293614183gD0H.jpg")});

        emailService.sendEmail(mailConfig, email);
    }
}
