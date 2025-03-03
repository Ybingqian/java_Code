package com.springaop.controller;

import com.springaop.config.MyAspect;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @MyAspect
    @RequestMapping("/test01")
    public String test01(){
        log.info("test01方法!");
//        int n=10/0;
        return "test01";
    }
    @RequestMapping("/test02")
    public void test02(){
        log.info("test02:无返回类型");
    }
}
