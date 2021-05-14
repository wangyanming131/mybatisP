package com.example.demo.config;

import com.example.demo.schedule.MyJobHasParam;
import com.example.demo.service.UserService;
import org.quartz.JobDataMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.*;

import java.util.Date;

/**
 * 配置jobDetail和trigger触发器,jobDetail有下面两种方式传参/不传参,trigger有多种方式,如下只列举两种方式
 */
@Configuration
public class QuartzConfig {

    /**
     * 方式一:不支持传参
     *
     * @return
     */
    @Bean
    MethodInvokingJobDetailFactoryBean methodInvokingJobDetailFactoryBean() {
        MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
        bean.setTargetBeanName("myJobNoParam");
        bean.setTargetMethod("job");
        return bean;
    }

    @Bean
    SimpleTriggerFactoryBean simpleTriggerFactoryBean() {

        SimpleTriggerFactoryBean bean = new SimpleTriggerFactoryBean();
        bean.setStartTime(new Date());
        bean.setRepeatCount(3);
        bean.setJobDetail(methodInvokingJobDetailFactoryBean().getObject());
        bean.setRepeatInterval(3000);
        return bean;
    }


    /**
     * 方式二:支持传参,参数配置在JobDataMap对象中
     *
     * @return
     */
    @Bean
    JobDetailFactoryBean jobDetailFactoryBean() {
        JobDetailFactoryBean bean = new JobDetailFactoryBean();
        bean.setJobClass(MyJobHasParam.class);
        JobDataMap map = new JobDataMap();
        map.put("userService", userService());

        bean.setJobDataMap(map);
        return bean;
    }

    @Bean
    CronTriggerFactoryBean cronTriggerFactoryBean() {
        CronTriggerFactoryBean bean = new CronTriggerFactoryBean();
        bean.setCronExpression("0/10 0 * * * ?");
        bean.setJobDetail(jobDetailFactoryBean().getObject());
        return bean;
    }


    @Bean
    SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        bean.setTriggers(cronTriggerFactoryBean().getObject(), simpleTriggerFactoryBean().getObject());
        return bean;
    }


    @Bean
    UserService userService() {
        return new UserService();
    }

}
