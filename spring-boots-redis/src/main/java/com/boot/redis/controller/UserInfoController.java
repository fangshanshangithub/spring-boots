package com.boot.redis.controller;

import com.boot.redis.entity.UserInfo;
import com.boot.redis.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/add")
    public String saveUserInfo(UserInfo userInfo) {
        boolean flag = userInfoService.save(userInfo);
        return flag ? "true" : "false";

    }

}
