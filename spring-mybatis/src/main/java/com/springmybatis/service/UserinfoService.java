package com.springmybatis.service;

import com.springmybatis.mapper.UserInfoXmlMapper;
import com.springmybatis.mapper.UserinfoMapper;
import com.springmybatis.model.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserinfoService {
    @Autowired
    private UserinfoMapper userinfoMapper;
    @Autowired
    private UserInfoXmlMapper userInfoXmlMapper;

    public List<Userinfo> getAll(){
        return userinfoMapper.getAll();
    }

    public Userinfo login(String name,String password){
        return userinfoMapper.login(name,password);
    }

//    public List<Userinfo> login(String username,String password){
//        return userInfoXmlMapper.login(username,password);
//    }
}
