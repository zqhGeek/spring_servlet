package com.zero.spring.interceptor;

import cn.yiban.open.Authorize;
import cn.yiban.open.FrameUtil;
import cn.yiban.util.AESDecoder;
import com.google.gson.reflect.TypeToken;
import com.zero.spring.util.AESTool;
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
        String parameter = httpServletRequest.getParameter("verify_request");
        LOGGER.debug(parameter);
//        AESTool.decrypt(AESTool.parseHexStr2Byte(parameter), "4b5377df59d2cbcf58cef91ad2164509", "5b0ceae46e9bbe1e");
//        Authorize au = new Authorize("5b0ceae46e9bbe1e",  "4b5377df59d2cbcf58cef91ad2164509");
//        String url = au.forwardurl("http://f.yiban.cn/iapp120697", "test", Authorize.DISPLAY_TAG_T.WEB);
//        httpServletResponse.sendRedirect(url);
//        FrameUtil frameUtil = new FrameUtil(httpServletRequest,httpServletResponse,"5b0ceae46e9bbe1e","4b5377df59d2cbcf58cef91ad2164509","http://f.yiban.cn/iapp120697");
//        boolean perform = frameUtil.perform();
//        LOGGER.debug(perform);
        String result = AESDecoder.dec(parameter,"4b5377df59d2cbcf58cef91ad2164509","5b0ceae46e9bbe1e");
//        TypeToken<res>
//        String decryptString = AESTool.aesDecryptString(AESTool.parseHexStr2Byte(parameter), "4b5377df59d2cbcf58cef91ad2164509", "5b0ceae46e9bbe1e");
//        LOGGER.debug(decryptString);
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
