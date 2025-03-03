package com.springmybatis.mapper;

import com.springmybatis.model.Articleinfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleinfoXmlMapper {
    List<Articleinfo> getAll();

    List<Articleinfo> getArtAndUser();
}
