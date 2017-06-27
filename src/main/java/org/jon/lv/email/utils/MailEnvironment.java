package org.jon.lv.email.utils;

/**
 * @Package org.jon.lv.email.utils.MailEnvironment
 * @Description: MailEnvironment
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/6/27 11:24
 * version V1.0.0
 */
public interface MailEnvironment {

    // 默认环境配置
    String DEFAULT_CONFIGURATION_FILE = "mail-env.properties";

    /** smtp服务器 **/
    String MAIL_HOST ="mail.host";

    /** 发件人地址 **/
    String MAIL_FROM ="mail.from";

    /** 用户 **/
    String MAIL_USER="mail.user";

    /** 密码 **/
    String MAIL_PWD="mail.pwd";

    /** 是否认证 **/
    String MAIL_SMTP_AUTH="mail.smtp.auth";

    /** 超时时间 **/
    String MAIL_SMTP_TIMEOUT="mail.smtp.timeout";
}
