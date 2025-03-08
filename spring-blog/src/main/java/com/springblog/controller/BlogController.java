package com.springblog.controller;

import com.springblog.constant.BlogConstants;
import com.springblog.model.BlogInfo;
import com.springblog.model.JwtUtils;
import com.springblog.model.Result;
import com.springblog.service.BlogService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @RequestMapping("/getlist")
    public List<BlogInfo> getBlogList(){
        return blogService.getlBlogList();
    }

    /**
     * 获取博客详情页
     * @param id  博客id
     * @param request
     * @return
     */
    @RequestMapping("/getBlogDetail")
    public BlogInfo getBlogDetail(Integer id,HttpServletRequest request){
//        获取token
        String token = request.getHeader(BlogConstants.HEAD_TOKEN);
//        获取用户id,
        Integer userId = JwtUtils.getUserIdByToken(token);
        if(userId==null || userId<=0){
            log.error("获取id失败!,id:",userId);
            return null;
        }
//        判断当前博客是否为 登录用户的博客
        BlogInfo blogInfo = blogService.getBlogById(id);
        if(userId == blogInfo.getUserId()){
//            当前博客是 登录用户的,设置isLoginUser为1
            blogInfo.setIsLoginUser(1);
        }else{
            blogInfo.setIsLoginUser(0);
        }
        return blogInfo;
    }
    @RequestMapping("/add")
    public Result add(@RequestBody BlogInfo blog, HttpServletRequest request){
//        数据校验
        if(!StringUtils.hasLength(blog.getTitle()) || !StringUtils.hasLength(blog.getContent())){
            return Result.fail("标题或正文为空!");
        }
//        获取token
        String token = request.getHeader(BlogConstants.HEAD_TOKEN);
//        根据token,获取用户id
        Integer id = JwtUtils.getUserIdByToken(token);
        if(id==null || id<=0){
            return Result.fail("用户未登录!");
        }
        BlogInfo blogInfo = new BlogInfo();
        blogInfo.setUserId(id);
        blogInfo.setTitle(blog.getTitle());
        blogInfo.setContent(blog.getContent());
        Integer n = blogService.add(blogInfo);
        if(n>0){
            return Result.success("发布成功!");
        }else{
            return Result.fail("发布失败!");
        }
    }
    @RequestMapping("/delete")
    public Boolean deleteBlog(Integer id){
        if(id<=0){
            return false;
        }
        Integer n = blogService.deleteBlog(id);
        if(n>0){
            return true;
        }
        return false;
    }
    @RequestMapping("/update")
    public Result updateBlog(BlogInfo blogInfo){
        log.info("更新博文:blogInfo: {}",blogInfo);
//        数据校验
        if( blogInfo.getId()<=0 ||
            !StringUtils.hasLength(blogInfo.getTitle()) ||
           !StringUtils.hasLength(blogInfo.getContent())
        ){
            return Result.fail("内容不能为空!");
        }
        int n = blogService.updateBlog(blogInfo);
        if(n>0){
            return Result.success("更新成功!");
        }else{
            return Result.fail("更新失败!");
        }
    }
}
