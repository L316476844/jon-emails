package org.jon.lv.email.receive;

public class Main {

    public static void main(String[] args) {
        try {
//            new ReceiveMailHandler().receiveMail("username", "password");
            new ReceiveMailHandler().receiveMail("username", "password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
