package com.iaven;

import static org.junit.Assert.assertTrue;

import com.iaven.pojo.table.User;
import com.iaven.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
/**
 * Unit test for simple App.
 */
@SpringBootTest
@MapperScan("com.iaven.mapper")
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void contextLoads()
    {
    }
}
