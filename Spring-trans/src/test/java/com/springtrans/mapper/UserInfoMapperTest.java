package com.springtrans.mapper;

import com.springtrans.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoMapperTest {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    void login() {
//        UserInfo userInfo=new UserInfo();
//        userInfo.setUserName("张三");
//        userInfo.setPassword("123456");
        System.out.println(userInfoMapper.add("张三", "123456"));
    }
}