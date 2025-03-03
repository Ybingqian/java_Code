package com.springmvc.mapper;

import com.springmvc.model.MessageInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageMapper {

    Integer insertMessage(MessageInfo messageInfo);

    @Select("select * from message_info  where delete_flag=0")
    List<MessageInfo> selectAll();
}
