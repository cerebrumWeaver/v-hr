package org.javaboy.vhr.config.schedule;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @作者 cerebrumWeaver
 * @日期 2020/3/16 12:39
 */
public class SecondJop extends QuartzJobBean {
    private String name;
    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("hello:"+name+":"+new Date());
    }
}
