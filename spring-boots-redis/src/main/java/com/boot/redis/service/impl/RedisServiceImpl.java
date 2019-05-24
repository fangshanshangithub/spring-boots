package com.boot.redis.service.impl;

import com.boot.redis.service.RedisService;
import com.boot.redis.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public boolean setValue(String key, String value) {
        return redisUtils.set(key, value, 10000);
    }

    @Override
    public Object getValue(String key) {
        return null;
    }
}
