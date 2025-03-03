package com.springmybatis.model;

import lombok.Data;

import java.util.Date;

@Data
public class Articleinfo {
    private Integer id;
    private String title;
    private String content;
    private Integer uid;
    private Integer deleteflag;
    private Date createtime;
    private Date updatetime;

//    用户相关信息
    private String username;
    private String password;
}
