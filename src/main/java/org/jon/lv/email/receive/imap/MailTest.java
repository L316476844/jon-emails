package org.jon.lv.email.receive.imap;

/**
 * 邮件测试类
 *
 * @author athena
 *
 */
public class MailTest {

    public static void main(String[] args) {
        MessageParser.parse(SimpleMailReceiver.fetchInbox(HostType.TENCENT.getProperties(),
                AuthenticatorGenerator.getAuthenticator("316476844@qq.com", "QQ授权码非密码")));
    }
}