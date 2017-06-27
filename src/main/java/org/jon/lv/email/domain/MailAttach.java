package org.jon.lv.email.domain;

import java.io.Serializable;

/**
 * @Description: MailAttach
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/10 11:07
 * version V1.0.0
 */
public class MailAttach implements Serializable {
    private static final long serialVersionUID = 5678363785178540122L;
    /**
     * 名称
     */
    private String name;
    /**
     * 路径
     */
    private String path;

    public MailAttach(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
