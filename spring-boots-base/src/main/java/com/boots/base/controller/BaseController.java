package com.boots.base.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/base")
public class BaseController {

    @RequestMapping("/")
    public String baseIndex(){
        return "index";
    }

}
