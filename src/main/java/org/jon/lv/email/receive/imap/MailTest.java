package org.jon.lv.email.receive.imap;

/**
 * 邮件测试类
 *
 * @author athena
 *
 */
public class MailTest {

    public static void main(String[] args) {
        MessageParser.parse(SimpleMailReceiver.fetchInbox(HostType.NETEASE.getProperties(),
                AuthenticatorGenerator.getAuthenticator("youraccount", "yourpassword")));
    }
}