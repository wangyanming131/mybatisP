package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;


    @Value("${server.servlet.context-path}")
    private String contextPath;

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    @ResponseBody
    public String hello(@RequestParam(value = "name", required = false) String name) {
        return contextPath + " hello " + name;
    }

    @GetMapping(value = "/users")
    public String users() {
        return "user_list";
    }

    @GetMapping(value = "/getUser/{id}")
    @ResponseBody
    public User getUser(@PathVariable long id) {
        return userService.findById(id);
    }

    @ResponseBody
    @GetMapping(value = "/getUsersByName/{name}")
    public List<User> getUsersByName(@PathVariable String name) {
        return userService.getUsersByName(name);
    }

    @ResponseBody
    @GetMapping(value = "/userList")
    public List<User> userList() {
        return userService.queryAll();
    }

}
