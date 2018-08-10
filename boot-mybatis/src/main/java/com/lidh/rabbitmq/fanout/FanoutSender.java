package com.lidh.rabbitmq.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by lidhk on 2018/8/10.
 *
 * @author lidhk
 */
@Component
public class FanoutSender {

    @Autowired
    private AmqpTemplate template;

    public void send(){
        template.convertAndSend("fanoutExchange","","成功");
    }
}
