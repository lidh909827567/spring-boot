package com.lidh.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by lidhk on 2018/8/10.
 *
 * @author lidhk
 */
@Component
public class TopicReceiver {

    @RabbitHandler
    @RabbitListener(queues = "topic.message")
    public void process(String s){
        System.out.println("message:"+s);
    }

    @RabbitHandler
    @RabbitListener(queues = "topic.messages")
    public void process1(String s){
        System.out.println("messages:"+s);
    }
}
