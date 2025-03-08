package com.springblog.model;

import lombok.Data;

import java.util.Date;

@Data
public class BlogInfo {
    private int id;
    private String title;
    private String content;
    private int userId;
    private Integer isLoginUser;
    private int deleteFlag;
    private Date createTime;
    private Date updateTime;
//    重新获取 时间
    public String getCreateTime(){
//        将Date类型转换成String类型
        return DateUtils.format(createTime);
    }
}
