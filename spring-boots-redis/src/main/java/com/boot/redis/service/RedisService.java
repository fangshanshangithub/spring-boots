package com.boot.redis.service;


public interface RedisService {

    /**
     * 向redis 中保存数据
     * @param key
     * @param value
     * @return
     */
    boolean setValue(String key, String value);

    /**
     * 根据 key 获取对应的value 值
     * @param key
     * @return
     */
    Object getValue(String key);

}
