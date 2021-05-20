package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

// 表示SpringBoot应用
@SpringBootApplication
// 扫描mapper包,就不需要每个mapper上面加@Mapper注解了
@MapperScan(value = "com.example.demo.mapper")
// 开启缓存
@EnableCaching
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
