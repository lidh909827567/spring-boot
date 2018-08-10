package com.lidh.rabbitmq.direct;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 简单的交换机模式
 * 需要注意的地方,Direct模式相当于一对一模式,
 * 一个消息被发送者发送后,会被转发到一个绑定的消息队列中,然后被一个接收者接收!
 * 实际上RabbitMQ还可以支持发送对象:当然由于涉及到序列化和反序列化,
 * 该对象要实现Serilizable接口.HelloSender做出如下改写:
 * Created by lidhk on 2018/8/9.
 *
 * @author lidhk
 */
@Configuration
public class RabbitMqConfig {
    public static final String QUEUE_NAME = "rabbitmq_test";

    @Bean(name = "taskQueue")
    public Queue queue() {
        return new Queue(RabbitMqConfig.QUEUE_NAME);
    }
}
