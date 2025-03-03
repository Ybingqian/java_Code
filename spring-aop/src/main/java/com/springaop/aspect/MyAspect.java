package com.springaop.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 使用自定义注解
 */
@Slf4j
@Component
@Aspect
public class MyAspect {
    /**
     * 作用在被MyAspect注解修饰的方法上
     */
    @Before("@annotation(com.springaop.config.MyAspect)")
    public void before(){
        log.info("MyAspect before");
    }
    /**
     * 作用在被RequestMapping注解修饰放入方法上
     */
    @Before("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void after(){
        log.info("RequestMapping before");
    }
}
