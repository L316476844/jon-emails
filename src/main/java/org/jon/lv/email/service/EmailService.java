package org.jon.lv.email.service;

import org.jon.lv.email.domain.Email;
import org.jon.lv.email.domain.MailConfig;
import org.jon.lv.result.ResultDO;

/**
 * @Description: EmailService
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/10 11:13
 * version V1.0.0
 */
public interface EmailService {

    /**
     * 发送邮件
     * @param email
     * @return
     */
    ResultDO<Boolean> sendEmail(Email email);

    /**
     * 发送邮件
     * @param mailConfig
     * @param email
     * @return
     */
    ResultDO<Boolean> sendEmail(MailConfig mailConfig, Email email);
}
