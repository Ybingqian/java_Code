package com.springmvc.test;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/request")
public class requestController {
//    获取Cookie
//    传统方法
    @RequestMapping("/test01")
    public String getCookie(HttpServletRequest request, HttpServletResponse response) {
//       获取Cookie所有信息
        Cookie[] cookies = request.getCookies();
        //将Cookie信息放到StringBuilder中
        StringBuilder builder = new StringBuilder();
        //要先对Cookie进行判空处理
        if(cookies!=null){
            for(Cookie c:cookies ){
                builder.append(c.getName()+":"+c.getValue());
            }
        }
        return "cookie:"+builder;
    }
//    简易获取Cookie方法:
    @RequestMapping("/test02")
    public String getCookie02(@CookieValue("bite")String bite) {
        return "bite: "+bite;
    }
//    获取Session
//    先存储Session
    @RequestMapping("/test03")
    public String setSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session!=null) {
            session.setAttribute("name","zhangsan");
        }
        return "session 存储成功";
    }
//    获取Session:
    @RequestMapping("/test04")
    public String getSession(HttpServletRequest request){
        //若session不存在,不会创建HttpSession对象
        HttpSession session = request.getSession(false);
        String name=null;
        if(session!=null&session.getAttribute("name")!=null){
            name=(String)session.getAttribute("name");
        }
        return "name:"+name;
    }
//    简洁获取session
    @RequestMapping("/test05")
    public String getSession02(@SessionAttribute(value="name",required=false)String name){
        return "session name:"+name;
    }
    @RequestMapping("/test06")
    public String getSession03(HttpSession session) {
        String  name = (String)session.getAttribute("name");
        return "name:"+name;
    }
//    获取header:
    @RequestMapping("/test07")
    public String getHeader(HttpServletRequest request,HttpServletResponse response) {
        String header = request.getHeader("User-Agent");
        return "User-Agent: "+header;
    }
//    简洁获取Header:
    @RequestMapping("/test08")
    public String getHeader02(@RequestHeader("User-Agent") String userAgent) {
        return "User-Agent: "+userAgent;
    }
}
