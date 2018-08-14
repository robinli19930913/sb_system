package com.cn.system.web.api.rabbitmq;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by robin on 2018/5/22.
 */
@RestController
@RequestMapping(value="/rabbitmq")
public class RabbitMqController {
    @Autowired
    private RabbitMqSender rabbitMqSender;

    /**
     * 发送测试消息队列
     */
    @RequestMapping(value = "/addRabbitMq", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject addEntity(HttpSession httpSession) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("queues","hello");
        jsonObject.put("queuesType","user.login.email");
        jsonObject.put("id",15);
        jsonObject.put("userName","15011091366");
        jsonObject.put("body","这是一个内容");
        System.out.println("addEntity:"+System.currentTimeMillis());
        rabbitMqSender.send(jsonObject);
        rabbitMqSender.send();
        rabbitMqSender.send1();
        rabbitMqSender.send2();
        System.out.println("send:"+System.currentTimeMillis());
        return jsonObject;
    }
}
