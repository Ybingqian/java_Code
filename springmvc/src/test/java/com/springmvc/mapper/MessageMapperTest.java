package com.springmvc.mapper;

import com.springmvc.model.MessageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MessageMapperTest {
    @Autowired
    private MessageMapper messageMapper;

    @Test
    void selectAll() {
        System.out.println(messageMapper.selectAll());
    }
}