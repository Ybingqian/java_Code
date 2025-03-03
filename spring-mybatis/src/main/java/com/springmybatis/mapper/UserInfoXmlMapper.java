package com.springmybatis.mapper;

import com.springmybatis.model.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 使用xml方式配置文件
 * 1.配置.xml文件
 * 2.在.yml文件中指定 .xml的文件路径及后缀  classpath:mapper/**Mapper.xml
 */
@Mapper
public interface UserInfoXmlMapper {

    List<Userinfo> getAll();
//    增
    Integer insert(@Param("Userinfo") Userinfo userinfo);
//删:
    Integer delete(Integer id);
//    改
    Integer update(String password,String username );

    List<Userinfo> getAll2();

    List<Userinfo> getAll3();

//      #{} 和${}的区别-->
//    查询Integer类型
    List<Userinfo> selectById(Integer id);
    List<Userinfo> selectById2(Integer id);
//    查询String类型
    List<Userinfo> selectByUsername(String username);
    List<Userinfo> selectByUsername2(String username);

//    $的使用场景
    List<Userinfo> selectBySort(String sort);
    List<Userinfo> selectBySort2(String username);

//    动态SQL操作
    Integer insertCondition(Userinfo userinfo);
    Integer insertCondition2(Userinfo userinfo);
    Integer insertCondition3(Userinfo userinfo);
//    where标签
    List<Userinfo> selectCondetion(Userinfo userinfo);
    List<Userinfo> selectCondetion2(Userinfo userinfo);
    List<Userinfo> selectCondetion3(Userinfo userinfo);
//    set标签
    Integer updateCondition(Userinfo userinfo);
    Integer updateCondition2(Userinfo userinfo);
//    foreach 标签
    Integer deleleByIds();
    Integer deleleByIds2(List<Integer> ids);
}

