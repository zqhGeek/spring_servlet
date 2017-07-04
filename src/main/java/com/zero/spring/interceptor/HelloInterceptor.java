package com.zero.spring.interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zqh on 2017/7/3.
 */
public class HelloInterceptor implements HandlerInterceptor {
    private static final Logger LOGGER = Logger.getLogger(HelloInterceptor.class);

    /**
     *
     * @param httpServletRequest 请求内容
     * @param httpServletResponse 返回内容
     * @param o 表示被拦截请求目标的对象如Controller
     * @return 是否要将当前请求拦截，false请求将被终止
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        LOGGER.debug("执行到preHandle");
        return true;
    }

    /**
     *
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView 可改变现实的视图或修改发往视图的方法
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        LOGGER.debug("执行到postHandle");
        modelAndView.setViewName("hello_interceptor");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        LOGGER.debug("执行到afterCompletion");

    }
}
