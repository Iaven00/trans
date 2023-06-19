package com.example.controller;


import com.example.pojo.Transunit;
import com.example.service.Transunitservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tran")
public class TransunitController {


    @Autowired
    Transunitservice transunitservice;

    @GetMapping("/morethanrest")
    public List<Transunit> list_morethanrest(int rest){
        return transunitservice.list_morethanrest(rest);
    }


    @PostMapping("/update_rest")
    public int  update(int transid,int rest){
        return transunitservice.update_rest(transid,rest);
    }


}
