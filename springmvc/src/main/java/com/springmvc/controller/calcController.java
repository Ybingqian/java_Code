package com.springmvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/calc")
@RestController
public class calcController {

    @RequestMapping("/sum")
    public String getSum(Integer num1,Integer num2){
        Integer sum=num1+num2;
        return "计算器计算结果为:"+sum;
    }
}
