package com.springtrans.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LogInfoMapperTest {

    @Autowired
    private LogInfoMapper logInfoMapper;
    @Test
    void insert() {
        String name="杨洋";
        String op="插入一条数据";
        logInfoMapper.insert(name,op);
    }
}