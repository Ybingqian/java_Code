package com.springaop.controller;


import com.springaop.config.MyAspect;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @MyAspect
    @RequestMapping("/test01")
    public String test01(){
        log.info("user test01");
        return "test01";
    }
    @RequestMapping("/test02")
    public String test02(){
        log.info("user test02");
        return "test02";
    }
}
