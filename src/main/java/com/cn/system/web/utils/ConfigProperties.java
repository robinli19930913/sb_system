package com.cn.system.web.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ConfigProperties {
	private static final Log log = LogFactory.getLog(ConfigProperties.class);
    private static  String propertyUrl = "/config.properties";
    private static Properties property;
    static{
        InputStream is = null;
        is = ConfigProperties.class.getResourceAsStream(propertyUrl);
        property = new Properties();
        try {
            property.load(is);
        } catch (IOException e) {
            log.debug(e.getStackTrace());
        }
    }
    public static String getProperty(String key) {
        try {
            return new String(property.getProperty(key).getBytes("ISO-8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
    public static String getProperty(String key, String defaultValue) {
        return property.getProperty(key);
    }
    
    public static void main(String[] args) {
		System.out.println(ConfigProperties.getProperty("name"));
	}
}
