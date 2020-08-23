package com.hang.springbootdemon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {
    @RequestMapping("/getPersonByName")
    public String getPersonByName(String a){
        System.out.println("springboot访问成功");
        return "hello,spring boot";
    }
}

