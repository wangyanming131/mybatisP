package com.example.demo.controller;

import com.example.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/hello")
public class HelloController {

    @Autowired
    HelloService helloService;

    // 普通的文本发送
    @Autowired
    SimpleMailMessage simpleMailMessage;

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

    @Value(value = "${server.port}")
    Integer port;

    @GetMapping("/set")
    @ResponseBody
    public String set(HttpSession session) {
        session.setAttribute("user", "spring session");
        return String.valueOf(port);
    }

    /**
     * 测试考虑到SpringBoot将以集群方式启动,为了获取每一个请求到底是哪个SpringBoot提供服务,需要在每次请求返回当前服务的端口号,注入server.port即可
     * 打包后,集群方式启动nohup java -jar demo.jar --server.port=8080 &
     * nohup表示终端关闭时SpringBoot不停止运行,&表示让SpringBoot在后台启动
     *
     * @param session
     * @return
     */
    @GetMapping(value = "/get")
    @ResponseBody
    public String get(HttpSession session) {
        return session.getAttribute("user") + ":" + port;
    }

    /**
     * redis序列化方式不同key,value结果显示不同
     * 控制台打印:name:Tom,name2:Tom2,name3:Tom3
     * redis客户端显示:\xAC\xED\x00\x05t\x00\x04name:\xAC\xED\x00\x05t\x00\x03Tom,name2:\xAC\xED\x00\x05t\x00\x04Tom2,name3:Tom3
     *
     * @return
     */
    @GetMapping(value = "/getValue")
    @ResponseBody
    public String getValue() {
        String value = helloService.getValue();
        value += "," + helloService.getValue2();
        value += "," + helloService.getValue3();
        System.out.println(value);
        return value;
    }

    @RequestMapping(value = "/sendSimpleMail")
    @ResponseBody
    public String sendSimpleMail() {
        return "success";
    }

}
