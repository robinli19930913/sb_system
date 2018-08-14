package com.cn.system.web.api.rabbitmq;

/**
 * Created by robin on 2018/5/22.
 */

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息队列接收类
 */
@Component
@RabbitListener(queues = {"hello","word"})//配置多个队列的监听
public class RabbitMqReceiver {
    @RabbitHandler
    public void process(String content) {
        System.out.println("process:"+System.currentTimeMillis());
        JSONObject jsonObject = JSONObject.parseObject(content);
        String queuesType = jsonObject.getString("queuesType");
        if("user.login.email".equals(queuesType)){
            userLoginEmail(jsonObject);
        }
    }

    private void userLoginEmail(JSONObject jsonObject) {
        System.out.println("我进行了操作了啊:"+jsonObject.toJSONString());
    }
}
