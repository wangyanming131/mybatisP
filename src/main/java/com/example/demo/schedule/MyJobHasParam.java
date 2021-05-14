package com.example.demo.schedule;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class MyJobHasParam extends QuartzJobBean {

    // 启动定时任务是注入bean,此处使用set方式,Autowired无法注入
    UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

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
            System.out.println("password:" + user.getPassword());
        }
    }
}
