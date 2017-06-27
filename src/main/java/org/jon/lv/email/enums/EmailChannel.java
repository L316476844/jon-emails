package org.jon.lv.email.enums;

/**
 * @Description: 通道
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/3 9:48
 * version V1.0.0
 */
public enum EmailChannel {
    DEFAULT("默认", 0),
    CUSTOM("自定义", 1);

    private final String name;
    private final int value;

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    EmailChannel(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public static String getNameByValue(Integer val) {
        if (val != null) {
            int value = val;
            for (EmailChannel type : EmailChannel.values()) {
                if (type.value == value) {
                    return type.name;
                }
            }
        }
        return "";
    }

    public EmailChannel getTypeByValue(int value) {
        for (EmailChannel type : EmailChannel.values()) {
            if (type.value == value) {
                return type;
            }
        }
        return null;
    }

}
