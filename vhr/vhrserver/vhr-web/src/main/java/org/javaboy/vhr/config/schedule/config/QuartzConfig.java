package org.javaboy.vhr.config.schedule.config;

import org.javaboy.vhr.config.schedule.SecondJop;
import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.SimpleTrigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.*;

/**
 * @作者 cerebrumWeaver
 * @日期 2020/3/16 12:44
 */
//@Configuration        //通过此注解可以开通定时任务
public class QuartzConfig {
    @Bean
    MethodInvokingJobDetailFactoryBean firstJobDetail(){
        MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
        bean.setTargetBeanName("firstJob");
        bean.setTargetMethod("sayHello");
        return bean;
    }

    @Bean
    JobDetailFactoryBean secondJobDetail(){
        JobDetailFactoryBean bean = new JobDetailFactoryBean();
        bean.setJobClass(SecondJop.class);
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("name", "sang");
        bean.setJobDataMap(jobDataMap);
        bean.setDurability(true);
        return  bean;
    }

    @Bean
    SimpleTriggerFactoryBean simpleTriggerFactoryBean(){
        SimpleTriggerFactoryBean bean = new SimpleTriggerFactoryBean();
        bean.setJobDetail(firstJobDetail().getObject());
        bean.setRepeatCount(3);
        bean.setStartDelay(1000);
        bean.setRepeatInterval(2000);
        return  bean;
    }

    @Bean
    CronTriggerFactoryBean cronTriggerFactoryBean(){
        CronTriggerFactoryBean bean =new CronTriggerFactoryBean();
        bean.setJobDetail(secondJobDetail().getObject());
        bean.setCronExpression("* * * * * ?");  //每秒调用一次
        return bean;
    }

    @Bean
    SchedulerFactoryBean schedulerFactoryBean(){
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        SimpleTrigger simpleTrigger = simpleTriggerFactoryBean().getObject();
        CronTrigger cronTrigger = cronTriggerFactoryBean().getObject();
        bean.setTriggers(simpleTrigger, cronTrigger);
        return bean;
    }
}
