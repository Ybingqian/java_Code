package com.springioc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 读取 .properties配置文件
 * 使用@Value注解 ${}的格式读取
 */
@RestController
@RequestMapping("/readpro")
public class ReadPropertiesController {
    @Value("${mykey.key1}")
    private String key1;

    @RequestMapping("/est01")
    public String readkey1(){
        return "key1:"+key1;
    }

}
