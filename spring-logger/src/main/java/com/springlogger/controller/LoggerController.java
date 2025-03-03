package com.springlogger.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logger")
public class LoggerController {
    private static Logger logger = LoggerFactory.getLogger(LoggerController.class);
    @RequestMapping("/get")
    public String getLogger(){
        logger.trace("trace信息");
        logger.debug("debug信息");
        logger.info("info信息");
        logger.warn("warn信息");
        logger.error("error信息");
//        springboot内置的日志框架地logback,logback没有fatal级别,将其映射到了error级别中.
//        logger.fatal("fatal信息");
        System.out.println("控制台信息");
        return "success";
    }
}
