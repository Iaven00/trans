package com.iaven.controller;


import com.iaven.pojo.table.User;
import com.iaven.service.UserService;
import com.iaven.utils.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("/login")
    @ResponseBody
    public ReturnObject<User> loginUser(String email,
                                        String password){

        ReturnObject<User> ret = new ReturnObject<>("fail",null);
        if(email==null || password==null) {return ret;}
//        User user = userService.loginUser(email,password);
        User user = new User();
        user.setEmail("1245");
        user.setId(1);
        user.setPassword("123456");
        user.setPhone("153");
        user.setUsername("iaven");
        if(user==null){
            //登录失败返回0
            return ret;
        }
        else {
//            user.setPassword("------");
            ret.setCode("success");
            ret.setObject(user);
        }
        return ret;
    }

}
