package com.springcaptcha.controller;

import ch.qos.logback.classic.spi.EventArgUtil;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.springcaptcha.model.YmlComponent;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 实现验证码功能
 */
@RequestMapping("/captcha")
@RestController
public class CaptchaController {
//    设置超时时间 1分钟
    private final static long TimeOut = 60*1000;

    @Autowired
    private YmlComponent ymlComponent;
    /**
     * 获取验证码图片
     */
    @RequestMapping("/get")
    public void getCaptcha(HttpServletResponse response , HttpSession session) throws IOException {
//        设置验证码图片格式
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(ymlComponent.getWidth(),ymlComponent.getHeight());
        //设置返回类型 :图片格式
        response.setContentType("image/jpeg");
        //禁止缓存
        response.setHeader("Progma", "No-cache");
//图形验证码写出来,写到文件中
        lineCaptcha.write(response.getOutputStream());
//        设置Session的key为验证码答案 , 用户输入验证码后于答案进行比较
        session.setAttribute(ymlComponent.getSession().getKey(),lineCaptcha.getCode());
//        存储设置Session 的时间,用于验证码超时
        session.setAttribute(ymlComponent.getSession().getTime(),System.currentTimeMillis());
//        关闭文件资源
        response.getOutputStream().close();
    }

    /**
     * 将用户的输入和进行比较
     * @param inputCode 用户的输入
     * @return 正确返回true,失败返回 false
     */
    @RequestMapping("/check")
    public Boolean check(String inputCode,HttpSession session){
//        1.数据校验
        if(!StringUtils.hasLength(inputCode)){
            return false;
        }
//        2.从Session中获取信息
        String code = (String)session.getAttribute(ymlComponent.getSession().getKey());
        long sessionTime = (long)session.getAttribute(ymlComponent.getSession().getTime());
//        3.数据比较
        if(inputCode.equalsIgnoreCase(code)){
            if( sessionTime != 0 && System.currentTimeMillis()-sessionTime <= TimeOut){
//                在规定时间内验证码有效
                return true;
            }
        }
        return false;
    }

}
