package com.springmybatis.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ArticleinfoXmlMapperTest {

    @Autowired
    private ArticleinfoXmlMapper articleinfoMapper;

    @Test
    void getAll(){
        System.out.println("获取所有数据: "+articleinfoMapper.getAll());
    }
//
    @Test
    void getArtAndUser() {
        System.out.println("多表查询: "+articleinfoMapper.getArtAndUser());
    }
}