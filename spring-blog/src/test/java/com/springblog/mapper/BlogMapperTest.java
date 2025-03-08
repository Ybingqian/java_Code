package com.springblog.mapper;

import com.springblog.model.BlogInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BlogMapperTest {
    @Autowired
    private BlogMapper blogMapper;

    @Test
    void selectAll() {
        System.out.println(blogMapper.selectAll());
    }

    @Test
    void selectById() {
        System.out.println(blogMapper.selectById(1));
    }

    @Test
    void updateBlog() {
       BlogInfo blogInfo=new BlogInfo();
       blogInfo.setId(1);
       blogInfo.setContent("新的一篇博客诞生了");
       blogInfo.setTitle("新的博客");
       blogMapper.updateBlog(blogInfo);
    }

    @Test
    void insertBlog() {
        BlogInfo blogInfo=new BlogInfo();
        blogInfo.setContent("新的一篇博客诞生了");
        blogInfo.setTitle("新的博客");
        blogInfo.setUserId(3);
        blogMapper.insertBlog(blogInfo);
    }
}