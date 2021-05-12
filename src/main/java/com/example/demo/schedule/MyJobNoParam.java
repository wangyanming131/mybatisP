package com.example.demo.schedule;

import org.springframework.stereotype.Component;

/**
 * 定义job,这种定义无法传参
 */
@Component
public class MyJobNoParam {

    public void job() {
        System.out.println("这种job定义方式无法传参");
    }
}
