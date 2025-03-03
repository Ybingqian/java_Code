package com.springbootmybatisplus;

import com.springbootmybatisplus.mapper.UserinfoMapper;
import com.springbootmybatisplus.model.Userinfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SpringBootMybatisPlusApplicationTests {
    @Autowired
    private UserinfoMapper userinfoMapper;
    @Test
    void contextLoads() {
//        List<Integer> list= Arrays.asList(new Integer[]{5,6,9});
//        System.out.println(userinfoMapper.selectBatchIds(list));
//        System.out.println("查询: "+userinfoMapper.selectById(1));
        Userinfo userinfo=new Userinfo();
//        userinfo.setId(9);
        userinfo.setAge(100);
        userinfo.setName("aaa");
//        System.out.println("修改: "+userinfoMapper.updateById(userinfo));
//        System.out.println("删除 ");
//        System.out.println(userinfoMapper.deleteById(1));
        System.out.println(userinfoMapper.insert(userinfo));
    }

}
