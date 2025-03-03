package com.springioc.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 通过配置文件读取对象.
 * 使用@ConfigurationProperties注解读取
 */
@ConfigurationProperties("student")
@Component
@Data
public class Student {
    private Integer id;
    private String name;
    private Integer score;
}
