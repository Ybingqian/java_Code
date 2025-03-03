package com.springbootmybatisplus.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
//映射的数据库名为: userInfo
@TableName("userinfo")
public class Userinfo {
    private Integer id;
//    当表字段与对象属性名不一致或不满足驼峰转换时,可以用@TableField 给对象属性指定表中的映射字段指定
    @TableField("username")
    private String name;
    private String password;
    private Integer age;
    private Integer gender;
    private String phone;
//    mybatisPlus会自动对表名进行 驼峰转换
    private Integer deleteFlag;
    private Date createTime;
    private Date updateTime;
}
