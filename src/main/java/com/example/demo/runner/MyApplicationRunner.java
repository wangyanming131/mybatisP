package com.example.demo.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

// 注册为spring容器的一个bean
@Component
// 表示启动任务的执行优先级,一个项目有多个执行任务,数值越小优先级越高,默认为Integer.MAX_VALUE最大值,优先级最低
@Order(100)
public class MyApplicationRunner implements ApplicationRunner {

    /**
     * 启动任务的核心逻辑,当启动项目时,run方法会自动执行.项目入口类的参数,如main方法的参数会被传到这里,如三国演义 西游记 --book=红楼梦
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        // nonOptionArgs命令行中无key的参数
        List<String> nonOptionArgs = args.getNonOptionArgs();
        System.out.println("nonOptionArgs:" + nonOptionArgs);
        // key/value形式的参数的key
        Set<String> optionNames = args.getOptionNames();
        for (String key : optionNames) {
            // 获取相应key的values
            List<String> values = args.getOptionValues(key);
            System.out.println(key + ":" + values);
        }

        // 命令行中所有参数
        String[] sourceArgs = args.getSourceArgs();
        System.out.println("sourceArgs:" + Arrays.toString(sourceArgs));

    }
}
