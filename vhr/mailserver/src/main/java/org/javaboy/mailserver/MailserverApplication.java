package org.javaboy.mailserver;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MailserverApplication {
    public final static String DIRECTNAME = "cerebrumWeaver";
    public static void main(String[] args) {
        SpringApplication.run(MailserverApplication.class, args);
    }

    @Bean
    Queue queue() {
        return new Queue("javaboy.mail.welcome");
    }

    //如果使用DirectExchange策略，以下两个bean可以省略掉，只配置上面的一个bean即可

    @Bean   //参数分别：名字、重启后是否有效、长期未用是否删除
    DirectExchange directExchange(){
        return  new DirectExchange(DIRECTNAME,true,false);
    }

    @Bean
    Binding binding(){
        return BindingBuilder.bind(queue()).to(directExchange()).with("direct");
    }
}
