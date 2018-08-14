package com.cn.system;

import com.cn.system.web.aop.WebInit;
import com.cn.system.web.aop.WebMvcConfigurerAdapterInit;
import com.cn.system.web.api.rabbitmq.RabbitMqReceiver;
import com.cn.system.web.api.rabbitmq.RabbitMqSender;
import com.cn.system.web.utils.SpringContextTool;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by robin on 2018/4/18.
 */
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
@ComponentScan({"com.cn.system.web.api","com.cn.system.web.service"})
@MapperScan({"com.cn.system.dao.mapper"})
@ImportResource(locations = {"spring.xml"})
@Import({WebInit.class,
        WebMvcConfigurerAdapterInit.class,
        SpringContextTool.class,
        RabbitMqSender.class,
        RabbitMqReceiver.class})
public class SystemApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SystemApplication.class);
    }

    public static void main(String[] args) {
        System.out.println("开始启动！");
        SpringApplication.run(SystemApplication.class, args);
        System.out.println("启动成功！");
    }
}
