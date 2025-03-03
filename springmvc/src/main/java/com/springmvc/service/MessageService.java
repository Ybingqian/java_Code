package com.springmvc.service;

import com.springmvc.mapper.MessageMapper;
import com.springmvc.model.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageMapper messageMapper;

    public Integer insert(MessageInfo messageInfo){
        return messageMapper.insertMessage(messageInfo);
    }
    public List<MessageInfo> select(){
        return messageMapper.selectAll();
    }
}
