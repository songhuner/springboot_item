package com.hang.springbootdemon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huangjh
 * @date 2020/9/1
 */
@Controller
@RequestMapping("/page")
public class PageController {
    @RequestMapping("/toIndex")
    public String toIndexPage(){
        return "index.html";
    }
}
