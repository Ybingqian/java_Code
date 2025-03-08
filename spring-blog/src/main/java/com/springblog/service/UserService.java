package com.springblog.service;

import com.springblog.mapper.BlogMapper;
import com.springblog.mapper.UserInfoMapper;
import com.springblog.model.BlogInfo;
import com.springblog.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private BlogMapper blogMapper;

    public UserInfo login(String name ){
        return userInfoMapper.selectByName(name);
    }

    public UserInfo selectById(Integer id){
        return userInfoMapper.selectById(id);
    }

    public BlogInfo selectByAuthorId(Integer id){
        if(id==null || id<=0){
            log.error("作者id不合法:id :{}",id);
            return null;
        }
        return blogMapper.selectById(id);
    }

}
