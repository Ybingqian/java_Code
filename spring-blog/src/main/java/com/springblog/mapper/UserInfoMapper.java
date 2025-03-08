package com.springblog.mapper;

import com.springblog.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoMapper {
//  根据用户名查询用户信息
    @Select("select * from user_info where user_name=#{name}")
    UserInfo selectByName(String name);

    @Select("select * from user_info where id=#{id}")
    UserInfo selectById(Integer id);

}
