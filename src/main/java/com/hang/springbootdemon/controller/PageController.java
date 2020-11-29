package com.hang.springbootdemon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 页面访问
 * @author huangjh
 * @date 2020/9/1
 */
@Controller
@RequestMapping("/page")
public class PageController {
    @RequestMapping("/toIndex")
    public String toIndexPage(){
        System.out.println("访问成功");
        return "/index.html";
    }
}
