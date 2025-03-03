package com.springioc.component;

import org.springframework.stereotype.Component;

@Component
public class UserComponent {
    public void say(){
        System.out.println("hi, user Component...");
    }
}
