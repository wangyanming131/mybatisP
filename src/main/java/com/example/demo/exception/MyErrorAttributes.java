package com.example.demo.exception;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

// 此处component注解不能少,否则该自定义异常不起作用,注册成bean以后,springboot就不会使用默认的DefaultErrorAttributes的实例了
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        return super.getErrorAttributes(webRequest, options);
    }


    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        if ((Integer) map.get("status") == 500) {
            map.put("message", "自定义异常:服务器内部错误,请联系客服人员");
        }
        return map;
    }
}
