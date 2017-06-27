package org.jon.lv.email.enums;

/**
 * @Description: 状态
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/3 9:48
 * version V1.0.0
 */
public enum EmailStatus {
    SUCCESS("成功", 0),
    FAILED("失败", 1),
    EXCEPTION("异常", 2);

    private final String name;
    private final int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    EmailStatus(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (EmailStatus status : EmailStatus.values()) {
                if (status.value == value) {
                    return status.name;
                }
            }
        }
        return "";
    }

    public EmailStatus getTypeByValue(int value) {
        for (EmailStatus status : EmailStatus.values()) {
            if (status.value == value) {
                return status;
            }
        }
        return null;
    }

}
