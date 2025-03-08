package com.springblog.model;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfo {
    private int id;
    private String userName;
    private String password;
    private String githupUrl;
    private int deleteFlag;
    private Date createTime;
    private Date updateTime;
}
