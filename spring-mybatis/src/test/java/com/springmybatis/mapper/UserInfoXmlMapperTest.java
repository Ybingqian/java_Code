package com.springmybatis.mapper;

import com.springmybatis.model.Userinfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserInfoXmlMapperTest {

    @Autowired
    private UserInfoXmlMapper userInfoXmlMapper;
    @Test
    void getAll() {
        System.out.println("查询: "+userInfoXmlMapper.getAll());
    }

    @Test
    void insert() {
        Userinfo userinfo=new Userinfo();
        userinfo.setUsername("yang");
        userinfo.setPassword("23333");
        userinfo.setAge(22);
        userinfo.setGender(1);
        System.out.println("插入: "+userInfoXmlMapper.insert(userinfo) +"id为: "+userinfo.getId());
    }

    @Test
    void delete() {
        System.out.println("删除: "+userInfoXmlMapper.delete(8));
    }

    @Test
    void update() {
        System.out.println("改: "+userInfoXmlMapper.update("000000", "yang"));
    }
    @Test
    void getAll2() {
        System.out.println("查询: "+userInfoXmlMapper.getAll2());
    }
    @Test
    void getAll3() {
        System.out.println("查询: "+userInfoXmlMapper.getAll3());
    }

    //      #{} 和${}的区别
    @Test
    void selectById() {
        System.out.println("# Integer查询: "+userInfoXmlMapper.selectById(1));
    }
    @Test
    void selectById2() {
        System.out.println("$ Integer查询: "+userInfoXmlMapper.selectById2(1));
    }

    @Test
    void selectByUsrname() {
        System.out.println("# String 查询: "+userInfoXmlMapper.selectByUsername("qian"));
    }

//    查询失败,
//    @Test
//    void selectByUsrname2() {
//        System.out.println("# String 查询: "+userInfoXmlMapper.selectByUsername2("qian"));
//    }
    @Test
    void selectBySort() {
        System.out.println("$ sort: "+userInfoXmlMapper.selectBySort("desc"));
    }

    @Test
    void selectBySort2() {
        System.out.println("$: "+userInfoXmlMapper.selectBySort2("yang"));
    }

    @Test
    void insertCondition() {
        Userinfo userinfo=new Userinfo();
        userinfo.setUsername("zhaozhao");
        userinfo.setPassword("4444");
        userinfo.setAge(22);
        userinfo.setGender(1);
        System.out.println("动态插入: "+userInfoXmlMapper.insertCondition(userinfo));
    }
    @Test
    void insertCondition2() {
        Userinfo userinfo=new Userinfo();
        userinfo.setUsername("hahah");
//        userinfo.setPassword("4444");
//        userinfo.setAge(22);
//        userinfo.setGender(1);
        System.out.println("动态插入: "+userInfoXmlMapper.insertCondition2(userinfo));
    }
    @Test
    void insertCondition3() {
        Userinfo userinfo=new Userinfo();
//        userinfo.setUsername("hahah");
        userinfo.setPassword("4444");
        userinfo.setAge(22);
//        userinfo.setGender(1);
        System.out.println("动态插入: "+userInfoXmlMapper.insertCondition3(userinfo));
    }

    @Test
    void selectCondetion() {
        Userinfo userinfo=new Userinfo();
        userinfo.setAge(30);
        userinfo.setGender(1);
        userinfo.setDeleteflag(0);
        System.out.println(userInfoXmlMapper.selectCondetion(userinfo));
    }
    @Test
    void selectCondetion2() {
        Userinfo userinfo=new Userinfo();
//        userinfo.setAge(30);
        userinfo.setGender(1);
        userinfo.setDeleteflag(0);
        System.out.println(userInfoXmlMapper.selectCondetion2(userinfo));
    }
     @Test
    void selectCondetion3() {
        Userinfo userinfo=new Userinfo();
//        userinfo.setAge(30);
        userinfo.setGender(1);
//        userinfo.setDeleteflag(0);
        System.out.println(userInfoXmlMapper.selectCondetion3(userinfo));
    }

    @Test
    void updateCondition() {
        Userinfo userinfo=new Userinfo();
        userinfo.setAge(30);
        userinfo.setGender(1);
        userinfo.setId(6);
        userinfo.setUsername("冰");
        System.out.println(userInfoXmlMapper.updateCondition(userinfo));
    }
    @Test
    void updateCondition2() {
        Userinfo userinfo=new Userinfo();
//        userinfo.setAge(30);
        userinfo.setGender(1);
        userinfo.setId(6);
//        userinfo.setUsername("冰");
        System.out.println(userInfoXmlMapper.updateCondition2(userinfo));
    }

    @Test
    void deleleByIds() {
        System.out.println(userInfoXmlMapper.deleleByIds());
    }

    @Test
    void deleleByIds2() {
        List<Integer> list= Arrays.asList(new Integer[]{10,12,15});
        System.out.println(userInfoXmlMapper.deleleByIds2(list));
    }
}