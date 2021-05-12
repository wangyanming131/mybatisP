package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 跨域处理,每个方法都加@CrossOrigin注解比较麻烦,甚至加在controller上面也比较麻烦,此处为全局配置
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


    /**
     * addMapping("/**")表示本应用所有方法都经过跨域处理,allowedMethods表示允许通过的请求数,allowedHeaders表示允许请求头
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:18001/demo")
                .allowedMethods("*")
                .allowedHeaders("*");
    }
}
