package com.iaven;

import static org.junit.Assert.assertTrue;

import com.iaven.pojo.table.User;
import com.iaven.service.MailService;
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

    @Autowired
    MailService mailService;
    /**
     * Rigorous Test :-)
     */
    @Test
    public void contextLoads()
    {
        mailService.sendCodeType("1245325661@qq.com",100);
        System.out.println(mailService.getCode("1245325661@qq.com",100));
    }
}
