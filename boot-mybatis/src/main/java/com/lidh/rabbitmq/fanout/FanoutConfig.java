package com.lidh.rabbitmq.fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 那前面已经介绍过了,Fanout Exchange形式又叫广播形式,
 * 因此我们发送到路由器的消息会使得绑定到该路由器的每一个Queue接收到消息,
 * 这个时候就算指定了Key,或者规则(即上文中convertAndSend方法的参数2),也会被忽略!
 * Created by lidhk on 2018/8/10.
 *
 * @author lidhk
 */
@Configuration
public class FanoutConfig {

    @Bean(name = "Amessage")
    public Queue AMessage() {
        return new Queue("fanout.A");
    }

    @Bean(name = "Bmessage")
    public Queue BMessage() {
        return new Queue("fanout.B");
    }

    @Bean(name = "Cmessage")
    public Queue CMessage() {
        return new Queue("fanout.C");
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    Binding bindingA(@Qualifier("Amessage") Queue queue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    @Bean
    Binding bindingB(@Qualifier("Bmessage") Queue queue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

    @Bean
    Binding bindingC(@Qualifier("Cmessage") Queue queue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }
}
