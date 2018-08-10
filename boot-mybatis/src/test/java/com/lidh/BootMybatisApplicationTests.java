package com.lidh;

import com.lidh.rabbitmq.direct.Sender;
import com.lidh.rabbitmq.fanout.FanoutSender;
import com.lidh.rabbitmq.topic.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes=BootMybatisApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class BootMybatisApplicationTests {


    @Autowired
    private Sender sender;

    @Autowired
    private TopicSender topicSender;

    @Autowired
    private FanoutSender fanoutSender;

    @Test
    public void contextLoads() {
        sender.send();
    }

    @Test
    public void topicSender() {
        topicSender.send();
    }

    @Test
    public void fanoutSender() {
        fanoutSender.send();
    }
}
