package com.yufop.tran.controller;

import com.yufop.tran.pojo.table.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/hello")
public class testController {

    @RequestMapping({"/", "/login"})
    public String index(Model model) {
        return "index"; //返回的是index.html的页面
    }

    @RequestMapping("/center")
    public String helloThymeleaf(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if(user!=null){
            model.addAttribute("username", user.getUsername());
            model.addAttribute("identity", user.getIdentity());
        }
        return "center";
    }

}