package com.cn.system.web.api.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.context.annotation.Bean;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Configuration;
/**
 * Created by robin on 2018/5/23.
 */
@Configuration
public class RabbitTopic {
    private final static String message = "topic.message";
    private final static String messages = "topic.messages";
    //创建队列
    @Bean
    public Queue queueMessage() {
        return new Queue(RabbitTopic.message);
    }
    //创建队列
    @Bean
    public Queue queueMessages() {
        return new Queue(RabbitTopic.messages);
    }
    //创建交换器
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }
    //对列绑定并关联到ROUTINGKEY
    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }
    //对列绑定并关联到ROUTINGKEY
    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");//*表示一个词,#表示零个或多个词
    }
}
