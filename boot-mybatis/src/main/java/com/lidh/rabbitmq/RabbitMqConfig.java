package com.lidh.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
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
