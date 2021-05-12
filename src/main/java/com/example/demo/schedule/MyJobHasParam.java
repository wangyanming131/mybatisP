package com.example.demo.schedule;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class MyJobHasParam extends QuartzJobBean {

    @Autowired
    private UserService userService;

    /**
     * 任务启动时,该方法会被执行
     *
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    protected void executeInternal(org.quartz.JobExecutionContext jobExecutionContext) throws JobExecutionException {
        User user = userService.findById(1);
        if (user != null) {
            System.out.println(user.getPassword());
        }
    }
}
