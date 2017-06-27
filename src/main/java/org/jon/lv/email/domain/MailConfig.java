package org.jon.lv.email.domain;


import org.jon.lv.verify.ValidateHelper;

import java.io.Serializable;

/**
 * @Description: MailConfig 配置
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/10 10:41
 * version V1.0.0
 */
public class MailConfig implements Serializable{
    private static final long serialVersionUID = -8379081217191007866L;

    /**
     * 发件人邮箱服务器
     */
    private String emailHost;

    /**
     * 发件人用户名
     */
    private String emailUserName;

    /**
     * 发件人密码
     */
    private String emailPassword;

    /**
     * 发件人邮箱
     */
    private String emailFrom;

    public String getEmailHost() {
        return emailHost;
    }

    public void setEmailHost(String emailHost) {
        this.emailHost = emailHost;
    }

    public String getEmailUserName() {
        return emailUserName;
    }

    public void setEmailUserName(String emailUserName) {
        this.emailUserName = emailUserName;
    }

    public String getEmailPassword() {
        return emailPassword;
    }

    public void setEmailPassword(String emailPassword) {
        this.emailPassword = emailPassword;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    /**
     * 校验参数
     * @return
     */
    public String verifyConfig(){
        if(ValidateHelper.isEmpty(this.emailHost)){
            return "邮箱服务器不能为空";
        }
        if(ValidateHelper.isEmpty(this.emailUserName)){
            return "邮箱服务器用户名不能为空";
        }
        if(ValidateHelper.isEmpty(this.emailPassword)){
            return "邮箱服务器密码不能为空";
        }
        if(ValidateHelper.isEmpty(this.emailFrom)){
            return "发件人邮箱不能为空";
        }
        if(!this.emailFrom.contains("@")){
            return "邮箱格式错误";
        }
        String suffix = this.emailFrom.split("@")[1];
        if(!this.emailHost.endsWith(suffix)){
            return "发件邮箱必须与邮箱服务保持一致";
        }

        return null;
    }
}
