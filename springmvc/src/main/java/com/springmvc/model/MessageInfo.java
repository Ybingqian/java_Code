package com.springmvc.model;

import lombok.Data;

import java.util.Date;

@Data
public class MessageInfo {
    private Integer id;
    private String from;
    private String to;
    private String message;
    private Integer deleteflag;
    private Date createTime;
    private Date updateTime;
}
