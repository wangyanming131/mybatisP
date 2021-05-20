package com.example.demo.service.impl;

import com.example.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

/**
 * getValue()三个方法redis序列化的方式不同,在reds客户端显示结果不一样
 */
@Service(value = "helloService")
public class HelloServiceImpl implements HelloService {

    @Autowired
    RedisTemplate redisTemplate;


    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public String getValue() {
        ValueOperations ops = redisTemplate.opsForValue();
        String key = "name";
        String value = "Tom";
        ops.set(key, value);
        Object value2 = ops.get(key);
        return key + ":" + value2.toString();
    }


    @Override
    public String getValue2() {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        ValueOperations ops = redisTemplate.opsForValue();
        String key = "name2";
        String value = "Tom2";
        ops.set(key, value);
        Object value2 = ops.get(key);
        return key + ":" + value2.toString();
    }

    @Override
    public String getValue3() {
        ValueOperations ops = stringRedisTemplate.opsForValue();
        String key = "name3";
        String value = "Tom3";
        ops.set(key, value);
        String value2 = ops.get(key).toString();
        return key + ":" + value2;
    }
}
