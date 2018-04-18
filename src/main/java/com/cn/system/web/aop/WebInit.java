package com.cn.system.web.aop;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@Component
public class WebInit implements ServletContextListener {

    private static final Logger log = LoggerFactory.getLogger(WebInit.class);
    @Resource
    Environment environment;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.error("项目成功启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.error("项目关闭");
    }
}
