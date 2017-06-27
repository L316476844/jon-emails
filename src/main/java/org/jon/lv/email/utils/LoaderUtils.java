package org.jon.lv.email.utils;


import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;

import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;

/**
 * @Package org.jon.lv.email.utils.LoaderUtils
 * @Description: 加载
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/6/27 11:14
 * version V1.0.0
 */
public class LoaderUtils {
    private static final Logger LOGGER = Logger.getLogger(LoaderUtils.class);
    public static URL getResource(String resource) {
        ClassLoader classLoader = null;
        URL url = null;
        try {
            classLoader = LoaderUtils.class.getClassLoader();
            if (classLoader != null) {
                LOGGER.debug("Trying to find [" + resource + "] using " + classLoader + " class loader.");
                url = classLoader.getResource(resource);
                if (url != null) {
                    return url;
                }
            }
        } catch (Exception ex) {
            LOGGER.warn("Caught Exception while in Loader.getResource.", ex);
        }

        LogLog.debug("Trying to find [" + resource + "] using ClassLoader.getSystemResource().");
        return ClassLoader.getSystemResource(resource);
    }


    public static void main(String[] args) {
        URL url = getResource("mail-env.properties");
        System.out.println(url);
    }
}
