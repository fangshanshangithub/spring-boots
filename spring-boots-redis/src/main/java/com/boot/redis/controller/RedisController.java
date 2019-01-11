package com.boot.redis.controller;

import com.boot.redis.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("redis")
public class RedisController {
    public static int brower_count = 0;

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping("add")
    public String add(String type) {
        brower_count ++;
        System.out.println("brower_count----" + brower_count);
        if("String".equals(type)) {
            redisUtils.set("add","abc123一二三");
        }
        else if("Hash".equals(type)) {
            HashMap<String, String> map = new HashMap<>();
            map.put("a", "aaaaa");
            map.put("b", "bbbbb");
            redisUtils.set("add_hash", map);
        }

        return "ok";

    }


    @RequestMapping("get")
    public Object get(String type) {
        brower_count ++;
        System.out.println("brower_count----" + brower_count);
        if("String".equals(type)) {
            return redisUtils.get("add");
        }
        else if("Hash".equals(type)) {

            return  redisUtils.get("add_hash");
        }

        return "ok";

    }

}
