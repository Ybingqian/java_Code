package com.springblog.controller;

import com.springblog.constant.BlogConstants;
import com.springblog.model.*;
import com.springblog.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public Result login(String username, String password ,
                        HttpServletRequest request, HttpServletResponse response){
        //1.数据校验
        if(!StringUtils.hasLength(username) || !StringUtils.hasLength(password)){
            return Result.fail("用户名或密码为空!");
        }
        UserInfo user = userService.login(username);
//        用户不存在
        if(user == null || user.getId()<=0){
            return Result.fail("用户不存在!");
        }
////        密码有误
//        if(!user.getPassword().equals(password)){
//            return Result.fail("密码有误!");
//        }
//        进行MD5加密
        if(!SecurityUtils.verify(password,user.getPassword())){
            return Result.fail("密码有误!");
        }
//        登录成功,设置Token 并返回token
        Map<String,Object> claims = new HashMap<>();
        claims.put(BlogConstants.TOKEN_ID,user.getId());
        claims.put(BlogConstants.TOKEN_USERNAME,username);
        String token = JwtUtils.genTwt(claims);
        System.out.println("token: "+token);
//        将Token作为数据 返回
        return Result.success(token);
    }

    @RequestMapping("/getUserInfo")
    public UserInfo getUserById(HttpServletRequest request){
//        1.从header中获取用户信息
        String token = request.getHeader(BlogConstants.HEAD_TOKEN);
//        从token中获取用户id
        Integer id = JwtUtils.getUserIdByToken(token);
        if(id == null){
//            用户未登录
            return null;
        }
        return userService.selectById(id);
    }

    @RequestMapping("/getAuthorInfo")
    public Result getAuthorById(Integer id){
//        根据博客id获取作者id
        BlogInfo blogInfo = userService.selectByAuthorId(id);
        if(blogInfo==null){
            log.error("未获取到博客信息: ",blogInfo);
            return Result.fail("未获取到博客信息");
        }
        Integer userId=blogInfo.getUserId();
        UserInfo userInfo = userService.selectById(userId);
        return Result.success(userInfo);
    }

}
