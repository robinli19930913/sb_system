package com.cn.system.web.aop;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by robin on 2018/4/20.
 */
@Configuration
public class WebMvcConfigurerAdapterInit extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptorInit())
                .addPathPatterns("/test/**")
                .addPathPatterns("/index/**");
    }
}
