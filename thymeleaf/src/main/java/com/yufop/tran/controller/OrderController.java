package com.yufop.tran.controller;


import com.yufop.tran.pojo.table.Order;
import com.yufop.tran.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller

public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("/order/selectBysp")
    @ResponseBody
    public List<Order> Listordersp(String phone){
        return orderService.list_sporders(phone);
    }

    @RequestMapping("/order/selectByrp")
    @ResponseBody
    public List<Order> Listorderrp(String phone){
        return orderService.list_rporders(phone);
    }


    @RequestMapping("/order/selectAll")
    @ResponseBody
    public List<Order> Listorder(){
        return orderService.list_orders();
    }

    @RequestMapping("/order/addOrder")
    @ResponseBody
    public int addOrder(Order order){
        return orderService.add_Order(order);
    }

}
