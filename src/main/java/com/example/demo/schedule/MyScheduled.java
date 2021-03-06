package com.example.demo.schedule;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

// 配置定时任务@Scheduled开启定时任务,时间都为毫秒
@Component
// 开启定时任务,该注解也可以放到spring启动器上
@EnableScheduling
public class MyScheduled {

    public MyScheduled() {
    }

    // 首次任务启动的延时时间
    @Scheduled(initialDelay = 300000, fixedRate = 200000)
    public void initialDelay() {
        System.out.println("initialDelay:" + new Date());
    }

    // 两次任务开始时间间隔
    @Scheduled(fixedRate = 500000)
    public void fixedRate() {
        System.out.println("fixedRate:" + new Date());
    }

    // 本次任务结束到下次任务开始时间间隔
    @Scheduled(fixedDelay = 400000)
    public void fixedDelay() {
        System.out.println("fixedDelay:" + new Date());
    }


    /**
     * 触发一次,如:Thu May 13 15:05:00 CST 2021
     */
    @Scheduled(cron = "0 5 * * * *")
    public void cron() {
        System.out.println("cron:" + new Date());
    }

}
