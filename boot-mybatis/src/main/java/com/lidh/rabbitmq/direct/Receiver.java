package com.lidh.rabbitmq.direct;

import com.lidh.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by lidhk on 2018/8/9.
 *
 * @author lidhk
 * <p>
 * 创建消息消费者Receiver。
 * 通过@RabbitListener注解定义该类对hello队列的监听，
 * 并用@RabbitHandler注解来指定对消息的处理方法。
 * 所以，该消费者实现了对rabbitmq_test队列的消费，消费操作为输出消息的字符串内容。
 */
@Component
public class Receiver {

    @RabbitHandler
    @RabbitListener(queues = "rabbitmq_test")
    public void process(User user) {
        System.out.println("Receiver" + "  " + user);
    }
}
