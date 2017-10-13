package org.jon.lv.email.receive;

/**
 * @Package org.jon.lv.email.receive.Config
 * @Description: 邮件配置的常量类
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/10/12 15:48
 * version V1.0.0
 */
public class Config {

    public static String MAIL_HOST = "pop3.163.com";//服务器ip

    public static int MAIL_PORT = 110;//端口

    public static String MAIL_TYPE = "pop3";//服务类型

    public static String MAIL_AUTH = "true";

    public static String MAIL_ATTACH_PATH = "upload/recMail/";//附件存放目录
}