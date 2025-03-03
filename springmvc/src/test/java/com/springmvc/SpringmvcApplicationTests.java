package com.springmvc;

import com.springmvc.mapper.MessageMapper;
import com.springmvc.model.MessageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringmvcApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private MessageMapper messageMapper;
    @Test
    void insertMessage() {
        MessageInfo messageInfo=new MessageInfo();
        messageInfo.setFrom("zhangsan");
        messageInfo.setTo("lisi");
        messageInfo.setMessage("hahahha");
        System.out.println(messageMapper.insertMessage(messageInfo));
    }
}
