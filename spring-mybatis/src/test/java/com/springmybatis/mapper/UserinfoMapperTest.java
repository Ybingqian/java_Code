package com.springmybatis.mapper;

import com.springmybatis.model.Userinfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 测试用例要加上 @SpringBootTest注解
 * 测试类在运行的时候,会自动加载Spring的运行环境
 */
@SpringBootTest
class UserinfoMapperTest {
    @Autowired
    private UserinfoMapper userinfoMapper;

    @BeforeEach
    void setUp() {
        System.out.println("BeforeEach----");
    }

    @AfterEach
    void tearDown() {
        System.out.println("AfterEach----");
    }

    @Test
    void getAll() {
        System.out.println(userinfoMapper.getAll());
    }

    @Test
    void getByid() {
        List<Userinfo> user = userinfoMapper.getByid(4);
        System.out.println(user);
    }

    @Test
    void getByid2() {
        List<Userinfo> user = userinfoMapper.getByid2(4);
        System.out.println(user);
    }

    @Test
    void getByid3() {
        List<Userinfo> user = userinfoMapper.getByid3("zhangsan",10);
        System.out.println(user);
    }
    @Test
    void getByid4() {
        List<Userinfo> user = userinfoMapper.getByid4("zhangsan",10);
        System.out.println(user);
    }

    @Test
    void insert() {
        Userinfo userinfo=new Userinfo();
        userinfo.setUsername("yangyang");
        userinfo.setPassword("12345678");
        userinfo.setAge(20);
        userinfo.setGender(2);
        System.out.println("insert: "+userinfoMapper.insert(userinfo));
    }

    @Test
    void insert2() {
        Userinfo userinfo=new Userinfo();
        userinfo.setUsername("yangyang");
        userinfo.setPassword("12345678");
        userinfo.setAge(20);
        userinfo.setGender(2);
        System.out.println("insert: "+userinfoMapper.insert2(userinfo));
        System.out.println("id: "+userinfo.getId());
    }

    @Test
    void delete() {
        System.out.println("删除条数: "+userinfoMapper.delete(7));
    }

    @Test
    void update() {
        System.out.println("更新: "+userinfoMapper.update("冰冰", "11111", 20, 6));
    }

    @Test
    void update2() {
        Userinfo userinfo=new Userinfo();
        userinfo.setUsername("qian");
        userinfo.setPassword("2222");
        userinfo.setAge(30);
        userinfo.setId(1);
        System.out.println("更新: "+ userinfoMapper.update2(userinfo));

    }

    @Test
    void getAll2() {
        System.out.println(userinfoMapper.getAll2(1));
    }

    @Test
    void getAll3() {
        System.out.println(userinfoMapper.getAll3());
    }

    @Test
    void getAll4() {
        System.out.println(userinfoMapper.getAll4(1));
    }
}