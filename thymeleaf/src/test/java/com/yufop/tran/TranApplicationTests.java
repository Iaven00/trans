package com.yufop.tran;

import com.yufop.tran.pojo.table.Order;
import com.yufop.tran.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@MapperScan("com.yufop.tran.mapper")
class TranApplicationTests {

    @Autowired
    OrderService orderService;

    @Test
    void contextLoads() {
        List<Order> orders = orderService.list_sporders("456");
        System.out.println(orders.size());

    }

}
