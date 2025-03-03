package com.springaop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
//@Component
@Slf4j
@Order(100)
public class Aspect02 {

    //使用 全限定路径名 调用类外切点
    @Before("com.springaop.aspect.Aspect01.pt()")
    public void before(){
        log.info("02 before");
    }

}
