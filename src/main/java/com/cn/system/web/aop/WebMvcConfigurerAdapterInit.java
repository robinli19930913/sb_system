package com.cn.system.web.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by robin on 2018/4/20.
 */
@Configuration
public class WebMvcConfigurerAdapterInit extends WebMvcConfigurerAdapter {
    @Bean
    HandlerInterceptorInit handlerInterceptorInit(){
        return new HandlerInterceptorInit();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration ir = registry.addInterceptor(handlerInterceptorInit());
        /*配置拦截的路径*/
        ir.addPathPatterns("/**");
        /*配置不拦截的路径*/
        ir.excludePathPatterns("/");
        ir.excludePathPatterns("/login*");
        ir.excludePathPatterns("/index*");
        ir.excludePathPatterns("/log/*");
    }
}
