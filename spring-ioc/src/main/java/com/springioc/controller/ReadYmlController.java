package com.springioc.controller;

import com.springioc.model.MyList;
import com.springioc.model.MyMap;
import com.springioc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 读取.yml文件
 * 使用@Value注解 ${}的格式读取
 *
 */
@RestController
@RequestMapping("/readyml")
public class ReadYmlController {
    @Value("${mykey.key1}")
    private Integer key1;

    @RequestMapping("/test01")
    public String readYml() {
        return "yml配置文件读取key1: " + key1;
    }
    @Value("${String.str1}")
    private String str1;
    @Value("${String.str2}")
    private String str2;
    @Value("${String.str3}")
    private String str3;

     @RequestMapping("/test02")
    public String readYml02(){
         System.out.println(str1);
         System.out.println(str2);
         System.out.println(str3);
         return "yml";
    }

    /**
     * 通过配置文件读取对象
     */
    @Autowired
    private Student student;

     @RequestMapping("/test03")
     public String readStudent() {
         return student.toString();
     }

    /**
     * 通过配置文件读取List集合
     */
     @Autowired
    private MyList list;

     @RequestMapping("/test04")
     public String readList(){
         return list.toString();
     }

    /**
     * 通过配置文件读取Map
     */
    @Autowired
     private MyMap myMap;
     @RequestMapping("/test05")
     public String resdMap(){
         return myMap.toString();
     }
}
