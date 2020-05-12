//package org.javaboy.vhr.config;
//
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
///**
// * @作者 cerebrumWeaver
// * @日期 2020/3/16 11:58
// */
//@Component
//public class ScheduleTest {
//    @Scheduled(fixedDelay = 1000)   //当前任务执行结束后延迟1秒再开启另一个任务
//    public void fixedDelay(){
//        System.out.println("fixedDelay"+new Date());
//    }
//
//    @Scheduled(fixedRate = 2000)    //当前任务开始执行2秒后开启另一个定时任务
//    public void fixedRate(){
//        System.out.println("fixedRate"+new Date());
//    }
//
//    @Scheduled(initialDelay = 1000, fixedRate = 2000)   //当前任务首次执行延迟1秒
//    public void initialDelay(){
//        System.out.println("initialDelay"+new Date());
//    }
//
//    @Scheduled(cron = "* * * * * ?") //定时任务每分钟(0 * * * * ?)/每秒钟(* * * * * ?)执行一次
//    public void cron(){
//        System.out.println("cron"+new Date());
//    }
//}
