package com.cn.system.web.api.rabbitmq;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息队列发送类
 * Created by robin on 2018/5/22.
 */
@Component
public class RabbitMqSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     *
     * @param queues 队列名
     * @param jsonObject 参数
     */
    public void send(String queues,JSONObject jsonObject) {
        this.amqpTemplate.convertAndSend(queues, jsonObject.toJSONString());
    }

    /**
     * @param jsonObject 参数
     */
    public void send(JSONObject jsonObject) {
        this.send(jsonObject.getString("queues"), jsonObject);
    }

    public void send() {
        String context = "hi, i am message all";
        System.out.println("Sender : " + context);
        this.amqpTemplate.convertAndSend("topicExchange", "topic.1", context);
    }

    public void send1() {
        String context = "hi, i am message 1";
        System.out.println("Sender : " + context);
        this.amqpTemplate.convertAndSend("topicExchange", "topic.message", context);
    }

    public void send2() {
        String context = "hi, i am messages 2";
        System.out.println("Sender : " + context);
        this.amqpTemplate.convertAndSend("topicExchange", "topic.messages", context);
    }
}
