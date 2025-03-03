package com.springioc.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public void say(){
        System.out.println("h1, user repository...");
    }
}
