package com.yufop.tran.controller;


import com.yufop.tran.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.URI;

@Controller
@RequestMapping("/manage")
public class ManageController {


    @Autowired
    OrderService orderService;


    @GetMapping("/state_change")
    public String changeState(int orderNo, String state, Model model,@RequestHeader("Referer") String referer){
        System.out.println(orderNo);
        orderService.change_state(orderNo,state);

        // 从Referer URL中获取相对路径
        URI refererUri = URI.create(referer);
        String relativePath = refererUri.getPath();

       return "redirect:" + relativePath;

    }

}
