package com.springbootmybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springbootmybatisplus.model.Userinfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserinfoMapper extends BaseMapper<Userinfo> {
//    BaseMapper已经帮我们写好了SQL语句的框架,我们只需要调用,并传入合适的参数就可以了,不用自己再写SQL语句
}
