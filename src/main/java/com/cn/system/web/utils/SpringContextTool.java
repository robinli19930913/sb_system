package com.cn.system.web.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * Created by robin on 2018/5/5.
 */
@Component
@PropertySource({"classpath:config.properties"})//自定义的properties需要在这里配置多个逗号隔开
public class SpringContextTool implements ApplicationContextAware {
    private static ApplicationContext context;
    private static Environment environment;

    public SpringContextTool() {
    }

    public void setApplicationContext(ApplicationContext acx) {
        context = acx;
        environment = context.getEnvironment();
    }

    public static ApplicationContext getApplicationContext() {
        return context;
    }

    public static String getValue(String key) {
        return environment.getProperty(key);
    }

    public static String requestChain() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return requestAttributes.getRequest().getHeader("REQUEST_APP_NAME_CHAIN");
    }

    public static String requestSeqNo() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        return requestAttributes.getRequest().getHeader("REQUEST_SEQ_NO");
    }

    public static String requestAppName() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        return requestAttributes.getRequest().getHeader("REQUEST_APP_NAME");
    }

    public static String requestXforwardedfor() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        return requestAttributes.getRequest().getHeader("x-forwarded-for");
    }

    public static String requestDengmiNo() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        return requestAttributes.getRequest().getHeader("REQUEST_DENGMI_NO");
    }
}
