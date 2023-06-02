package com.yufop.tran.controller;


import com.yufop.tran.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/manage")
public class ManageController {


    @Autowired
    OrderService orderService;


    @GetMapping("/state_change")
    @ResponseBody
    public int changeState(int orderId,String state){

        return orderService.change_state(orderId,state);

    }

}
