package com.springmvc.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

@RestController
@RequestMapping("/user")
public class loginController {
    @RequestMapping("/login")
    public Boolean login(String userName, String password, HttpSession session){
//        System.out.println("用户登录");
//        1.数据校验
        //法一:
//        if(userName==null || userName.length()==0 || password==null || password.length()==0){
//               return false;
//        }
        //法二
        if(!StringUtils.hasLength(userName) || !StringUtils.hasLength(password)){
            return false;
        }
        //判断:
//       使用equals方法时,通常将常量写在前面,目的:防 useraName为null,报空指针异常
        if("zhangsan".equals(userName) && "123456".equals(password)){
            session.setAttribute("userName",userName);
            return true;
        }
        return false;
    }
    @RequestMapping("/index")
    public String getUserName(@SessionAttribute("userName")String userName){
        return userName;
    }
}
