package com.example.controller;


import com.example.pojo.Transunit;
import com.example.service.Transunitservice;
import com.example.utils.Returnobj;
import com.example.utils.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/tran")
@EnableBinding(StreamClient.class)
public class TransunitController {


    @Autowired
    Transunitservice transunitservice;



    @GetMapping("/morethanrest")
    public List<Returnobj<Transunit>> list_morethanrest(int rest){
        return transunitservice.list_morethanrest(rest);
    }


    @PostMapping("/update_rest")
    public int  update(int transid,int rest){
        return transunitservice.update_rest(transid,rest);
    }



    @StreamListener(StreamClient.STREAM_DEMO)
    public void  consume(String message) {
        String mess[] = message.split("%");
        if(mess.length == 2){
            transunitservice.update_rest(Integer.parseInt(mess[0]),Integer.parseInt(mess[1]));
        }
        System.out.println("接收消息：{}"+ message);
    }

}
