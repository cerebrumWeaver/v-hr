package org.javaboy.mailserver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class MailserverApplicationTests {

    @Test
    void contextLoads() {
        Class<?> clazz=MailserverApplicationTests.class;
        System.out.println(new Class[]{clazz});

    }

}