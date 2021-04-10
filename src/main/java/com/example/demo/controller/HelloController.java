package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/hello")
public class HelloController {

    @RequestMapping(value = "/say/{path}", method = RequestMethod.GET)
    public String say(@PathVariable String path) {
        return path;
    }
}
