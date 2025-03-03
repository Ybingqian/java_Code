package com.springmybatis.controller;

import com.springmybatis.mapper.UserInfoXmlMapper;
import com.springmybatis.model.Userinfo;
import com.springmybatis.service.UserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequestMapping("/user")
@RestController
public class UserInfoController {
    @Autowired
    private UserinfoService userinfoService;

    @RequestMapping("/getAll")
    public List<Userinfo> getAll(){
        return userinfoService.getAll();
    }

    @RequestMapping("/login")
    public Boolean login(String name,String password){
        System.out.println("haha");
        if(userinfoService.login(name,password)==null){
            return false;
        }else{
            return true;
        }
    }
}
