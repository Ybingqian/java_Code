package com.springioc.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public void say(){
        System.out.println("hi,user  Service...");
    }
}
