package com.sen.myshop.service.redis.provider.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.sen.myshop.service.redis.api.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @Auther: Sen
 * @Date: 2019/10/5 21:38
 * @Description:
 */
@Service(version = "${services.versions.redis.v1}")
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public void set(String key, Object value, long seconds) {
        redisTemplate.opsForValue().set(key, value, seconds, TimeUnit.SECONDS);
    }

    @Override
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    @Override
    public void get(String key) {
        redisTemplate.opsForValue().get(key);
    }
}
