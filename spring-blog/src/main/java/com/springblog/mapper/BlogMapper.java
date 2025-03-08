package com.springblog.mapper;

import com.springblog.model.BlogInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BlogMapper {
//    显示博客列表
    @Select("select * from blog_info where delete_flag=0 order by id desc;")
    List<BlogInfo> selectAll();

//  根据博客Id查询博客信息
    @Select("select * from blog_info where id=#{id}")
    BlogInfo selectById(Integer id);

//    修改博客信息
    Integer updateBlog(BlogInfo blog);

////    删除博客,进行逻辑删除,实现和修改方法相同,可通用
//    @Update("update blog_info set delete_flag=1 where id=#{id}")
//    Integer deleteBlog(Integer id);

//     插入博客信息
    @Insert("insert into blog_info (title,content,user_id) values (#{title},#{content},#{userId})")
    Integer insertBlog(BlogInfo blog);

}
