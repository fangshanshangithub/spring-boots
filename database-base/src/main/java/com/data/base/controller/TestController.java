package com.data.base.controller;

import com.data.base.entity.UserInfo;
import com.data.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.RequestWrapper;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public List<UserInfo> test() {
       List<UserInfo> list =  userService.findAll();

       return  list;
    }

}
