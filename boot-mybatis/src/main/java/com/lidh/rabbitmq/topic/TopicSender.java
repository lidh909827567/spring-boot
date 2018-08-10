package com.lidh.rabbitmq.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by lidhk on 2018/8/10.
 *
 * @author lidhk
 */
@Component
public class TopicSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 方法的第一个参数是交换机名称,
     * 第二个参数是发送的key,
     * 第三个参数是内容,R
     * abbitMQ将会根据第二个参数去寻找有没有匹配此规则的队列,
     * 如果有,则把消息给它,如果有不止一个,则把消息分发给匹配的队列(每个队列都有消息!),
     * 显然在我们的测试中,参数2匹配了两个队列,因此消息将会被发放到这两个队列中,
     * 而监听这两个队列的监听器都将收到消息!那么如果把参数2改为topic.messages呢?
     * 显然只会匹配到一个队列,那么process2方法对应的监听器收到消息!
     */
    public void send() {
        String s = "sender";
        System.out.println("send:" + s);
        this.amqpTemplate.convertAndSend("exchange", "topic.saas", s);
    }
}
