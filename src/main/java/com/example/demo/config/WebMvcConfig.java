package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
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


    /**
     * 添加区域信息解析器:将MyLocaleResolver自定义的区域信息解析器添加在容器中,让系统去使用我们自己配置的解析器
     *
     * @return
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 设置调整视图
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
    }

}
