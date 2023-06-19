package com.yufop.tran.controller;


import com.yufop.tran.pojo.table.User;
import com.yufop.tran.service.UserService;
import com.yufop.tran.util.ReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import static com.yufop.tran.util.Global.*;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;



    @PostMapping("/login")
    public String processLogin(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               Model model, HttpSession session) {

        User user = userService.loginUser(username,password);
        if(user!=null){
            session.setAttribute("user", user);
            model.addAttribute("user",user);
            return "redirect:/hello/center";
        }else{
            model.addAttribute("msg","账号或密码错误，请检查！");
            return "index";
        }


    }
    @PostMapping("/register")
    @ResponseBody
    public int register(@RequestBody User user, @RequestParam("code")String codeValue, HttpSession session){
//    public int register(@RequestBody User user, @RequestParam("code")String codeValue,HttpSession session){

        return 0;
    }

    @GetMapping("/modifyUserInfo")
    @ResponseBody
    public int modifyUserInfo(Integer userId, String email, String name) {
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setUsername(name);
        return userService.modifyInfo(userId,newUser);

    }



    @PostMapping("/token_check")
    @ResponseBody
    public int token_check(){
        return SUCCESS;
    }

}
