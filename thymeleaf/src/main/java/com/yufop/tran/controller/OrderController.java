package com.yufop.tran.controller;


import com.yufop.tran.pojo.table.Order;
import com.yufop.tran.pojo.table.User;
import com.yufop.tran.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
    public String Listorder(Model model,HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user!=null){
            model.addAttribute("identity", user.getIdentity());
            model.addAttribute("orders",orderService.list_orders());
            return "ListAllOrder";
        }else{
            model.addAttribute("msg","请登录");
            return "index";
        }
    }

    @RequestMapping("/order/ToNewOrder")
    public String newOrder(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user!=null){
            model.addAttribute("identity", user.getIdentity());
            model.addAttribute("order",new Order());
            return "newOrder";
        }else{
            model.addAttribute("msg","请登录");
            return "index";
        }
    }

    @RequestMapping("/order/myOrder")
    public String myOrder(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        if(user!=null){
            String phone =user.getPhone();


            model.addAttribute("identity", user.getIdentity());
            model.addAttribute("receivedOrders",orderService.list_sporders(phone));
            model.addAttribute("sentOrders",orderService.list_rporders(phone));
            model.addAttribute("order",new Order());
            return "myOrder";
        }else{
            model.addAttribute("msg","请登录");
            return "index";
        }
    }

    @PostMapping("/order/newOrder")
    public String addOrder(@ModelAttribute("order") Order order,HttpSession session){
        orderService.add_Order(order);
        return "redirect:/order/selectAll";
    }



//    @RequestMapping("/order/addOrder")
//    @ResponseBody
//    public int addOrder(Order order){
//        return orderService.add_Order(order);
//    }

}
