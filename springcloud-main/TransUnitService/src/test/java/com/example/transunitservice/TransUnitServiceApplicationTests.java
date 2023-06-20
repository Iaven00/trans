package com.example.transunitservice;

import com.example.pojo.Transunit;
import com.example.service.Transunitservice;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan("com.example.mapper")
class TransUnitServiceApplicationTests {

    @Autowired
    Transunitservice transunitservice;

    @Test
    void contextLoads() {

    }

}
