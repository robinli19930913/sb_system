package com.cn.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by robin on 2018/4/18.
 */
@SpringBootApplication
public class SystemApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
        System.out.println("成功！");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SystemApplication.class);
    }
}
