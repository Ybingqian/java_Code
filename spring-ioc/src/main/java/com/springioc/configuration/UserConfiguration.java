package com.springioc.configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfiguration {
    public void say(){
        System.out.println("hi,user Configuration...");
    }
}
