package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User findById(long id) {
        return userMapper.findById(id);
    }

    public List<User> getUsersByName(String name) {
        return userMapper.getUsersByName(name);
    }

    public List<User> queryAll() {
        return userMapper.selectAll();
    }


}
