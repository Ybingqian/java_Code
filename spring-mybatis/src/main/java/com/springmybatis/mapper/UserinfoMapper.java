package com.springmybatis.mapper;

import com.springmybatis.model.Userinfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 注解方式连接 数据库操作
 * 要加上mapper注解
 */
@Mapper
public interface UserinfoMapper {

    @Select("select * from userinfo")
    List<Userinfo> getAll();

    @Select("select * from userinfo where id=#{id}")
    List<Userinfo> getByid(Integer id);

//    当只有一个参数时,select 中#{}中的参数和方法中的参数可以不一致;
//    但若有多个参数时,必须一致,若不一致要通过重命名解决 @Param
    @Select("select * from userinfo where id=#{id}")
    List<Userinfo> getByid2(Integer ID);

    @Select("select * from userinfo where username=#{username} and age=#{age}")
    List<Userinfo> getByid3(String username,Integer age);

     @Select("select * from userinfo where username=#{username} and age=#{age}")
    List<Userinfo> getByid4(@Param("username") String name,Integer age);

//  增
    @Insert("Insert into userinfo (username,password,age,gender) values (#{username},#{password}," +
            "#{age},#{gender})")
    Integer insert(Userinfo userinfo);

//   1. 对 对象 进行重命名@Param
//    2. @Options :返回主键
//    useGeneratedKeys: 让 mybatis使用jdbc中的getGeneratedKeys方法取出由数据库生成的唯一主键.
//    KeyProperty: 指定能够唯一识别对象的属性
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("Insert into userinfo (username,password,age,gender) values (#{Userinfo.username},#{Userinfo.password}," +
            "#{Userinfo.age},#{Userinfo.gender})")
    Integer insert2(@Param("Userinfo")Userinfo userinfo);

//删:
    @Delete("delete from userinfo where id=#{id}")
    Integer delete(Integer id);

//改:
    @Update("update userinfo set username=#{username},password=#{password},age=#{age} where id=#{id}")
    Integer update(String username,String password,Integer age,Integer id);

    @Update("update userinfo set username=#{Userinfo.username},password=#{Userinfo.password},age=#{Userinfo.age} where id=#{Userinfo.id}")
    Integer update2(@Param("Userinfo") Userinfo userinfo);

    /**
     * mysql中字段和java对象中的属性名不一致时,是无法进行映射的.返回的数据为null
     * mybatis会根据 方法的返回结果 进行赋值,
     * mybatis会获取数据库表中的列名,并在java对象中查找相同名字的属性,
     * 当查找到了ID列和id属性,mybatis就会进行赋值 将ID列赋值给id属性
     * @return
     */
//    ID列和id属性1不一致时,解决方法:
//    1.通过给ID列起别名 的方法
    @Select("select id,username,age,delete_flag as deleteflag," +
            "create_time as createtime,update_time as updatetime from userinfo " +
            "where id=#{id}")
    List<Userinfo> getAll2(Integer id);

    //2.结果映射
//    id="映射名" 给结果映射起个别名,方便之后shiyong@RestutMap复用映射名就可以了
    @Results(id="resultMap",value ={
            @Result(column = "delete_flag",property = "deleteflag"),
            @Result(column = "create_time",property = "createtime"),
            @Result(column = "update_time",property = "updatetime")
    })
    @Select("select * from userinfo")
    List<Userinfo> getAll3();

//    对结果映射进行复用
    @ResultMap(value="resultMap")
    @Select("select username,delete_flag from userinfo where id=#{id}")
    List<Userinfo> getAll4(Integer id);
//    3.驼峰命名法   map-underscore-to-camel-case: true
//    仅在.yml文件中进行配置, java代码不做任何处理

    @Select("select * from userinfo where username='${username}' and password='${password}'")
    Userinfo login(String username,String password);

}
