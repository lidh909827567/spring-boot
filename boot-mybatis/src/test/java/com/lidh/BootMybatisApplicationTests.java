package com.lidh;

import com.lidh.rabbitmq.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes=BootMybatisApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class BootMybatisApplicationTests {


    @Autowired
    private Sender sender;

    @Test
    public void contextLoads() {
        sender.send();
    }
}
