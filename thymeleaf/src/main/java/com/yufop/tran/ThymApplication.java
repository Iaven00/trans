package com.yufop.tran;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yufop.tran.mapper")
public class ThymApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThymApplication.class, args);
    }

}
