package com.zero.spring.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zqh on 2017/5/24.
 */
@Controller
@RequestMapping(value = "/hello")
public class HelloMvcController {
    private static final Logger LOGGER = Logger.getLogger(HelloMvcController.class);

    @RequestMapping(value = "/mvc")
    public String helloMvc() {
        return "hello_mvc";
    }
    @RequestMapping(value = "/mvc/{txt}")
    public String helloMvcInput(@PathVariable("txt") String txt) {
        LOGGER.debug(txt);
        return "hello_mvc";
    }
    @RequestMapping(value = "/interceptor")
    public ModelAndView helloInterception(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("hello_mvc");
        return modelAndView;
    }
}
