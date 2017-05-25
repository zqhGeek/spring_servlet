package com.zero.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zqh on 2017/5/24.
 */
@Controller
@RequestMapping(value = "/hello")
public class HelloMvcController {
    @RequestMapping(value = "/mvc")
    public String helloMvc() {
        return "hello_mvc";
    }
}
