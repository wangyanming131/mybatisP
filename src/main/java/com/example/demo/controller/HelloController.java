package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/hello")
public class HelloController {

    @RequestMapping(value = "/say/{path}", method = RequestMethod.GET)
    public String say(@PathVariable String path) {
        // 没有对应的视图,返回500错误,自动匹配到templates/error/5xx.html页面,并赋值相应异常熟悉
        return path;
    }

    @RequestMapping(value = "/read/{path}", method = RequestMethod.GET)
    @ResponseBody
    public String read(@PathVariable String path) {
        return path;
    }

}
