package com.lidh.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by lidhk on 2018/8/9.
 *
 * @author lidhk
 * <p>
 * 创建消息生产者Sender。通过注入AmqpTemplate接口的实例来实现消息的发送，
 * AmqpTemplate接口定义了一套针对AMQP协议的基础操作。
 * 在Spring Boot中会根据配置来注入其具体实现。在该生产者，我们会产生一个字符串，
 * 并发送到名为rabbitmq_test的队列中。
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(){
        String context = "rabbitmq_test" +"  " + new Date();
        System.out.println("send:" + context);
        this.amqpTemplate.convertAndSend("rabbitmq_test",context);
    }
}
