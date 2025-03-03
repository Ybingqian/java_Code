package com.springmvc.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("hello")
@RestController
public class helloController {
    //注解:url路径
//    指定请求方法:
//    @RequestMapping(value = "say",method= RequestMethod.GET)
    @RequestMapping(value = "say")
    public String say(){
        System.out.println("hello...");
        return "hello spring mvc";
    }
}
