package com.springblog.service;

import com.springblog.mapper.BlogMapper;
import com.springblog.model.BlogInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogMapper blogMapper;

    public List<BlogInfo> getlBlogList(){
        return blogMapper.selectAll();
    }

    public BlogInfo getBlogById(Integer id){
        return  blogMapper.selectById(id);
    }

    public Integer add(BlogInfo blog){
        return blogMapper.insertBlog(blog);
    }

    public Integer deleteBlog(Integer id){
        BlogInfo blogInfo=new BlogInfo();
        blogInfo.setId(id);
        blogInfo.setDeleteFlag(1);
        return blogMapper.updateBlog(blogInfo);
    }

    public Integer updateBlog(BlogInfo blogInfo){
        return blogMapper.updateBlog(blogInfo);
    }
}

