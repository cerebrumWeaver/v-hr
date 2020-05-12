package org.javaboy.vhr.config.schedule;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @作者 cerebrumWeaver
 * @日期 2020/3/16 12:37
 */
@Component
public class FirstJob {
    public void sayHello(){
        System.out.println("FirstJob:sayHello:"+new Date());
    }
}
