package com.lidh.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by lidhk on 2018/8/10.
 *
 * @author lidhk
 */
@Component
public class FanoutReceiver {
    @RabbitHandler
    @RabbitListener(queues = "fanout.A")
    public void Aprocess(String str) {
        System.out.println("A" + str);
    }

    @RabbitHandler
    @RabbitListener(queues = "fanout.B")
    public void Bprocess(String str) {
        System.out.println("B" + str);
    }

    @RabbitHandler
    @RabbitListener(queues = "fanout.C")
    public void Cprocess(String str) {
        System.out.println("C" + str);
    }
}
