package com.example.controller;



import com.example.pojo.Order;
import com.example.service.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    orderService orderservice;


    /**
     * 列出用户的所有订单
     * @param pageNum
     * @param pageSize
     * @param userid
     * @return
     */
    @GetMapping("/list_order")
    @ResponseBody
    public List<Order> get_allrecords(@RequestParam("pageNum")Integer pageNum, @RequestParam("pageSize")Integer pageSize, int userid){

        return orderservice.list_orders(userid);
    }




    /**
     * 根据收件人姓名查询订单
     * @param pageNum
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/search_orderbyname")
    @ResponseBody
    public List<Order> get_recordsbyname(@RequestParam("pageNum")Integer pageNum, @RequestParam("pageSize")Integer pageSize,int userid,String name){

        return orderservice.listbyrename(userid,name);
    }


    /**
     * 根据收获地址查询
     * @param pageNum
     * @param pageSize
     * @param userid
     * @param address
     * @return
     */
    @GetMapping("/search_orderbyaddress")
    @ResponseBody
    public List<Order> get_recordsbyaddress(@RequestParam("pageNum")Integer pageNum, @RequestParam("pageSize")Integer pageSize,int userid,String address){

        return orderservice.listbyaddress(userid,address);
    }



    /**
     * 选择物流公司提交订单
     * @param order
     * @return
     */
    @PostMapping("/submit_order")
    @ResponseBody
    public int order(Order order){


        return orderservice.submit_order(order);
    }


    /**
     * 撤销订单（退款）
     * @param orderid
     * @return
     */
    @PostMapping("/revoke_order")
    @ResponseBody
    public int revoke(int orderid){

        return orderservice.delete_bill(orderid);
    }

    /**
     * 查看用户账单
     * @param userid
     * @return
     */
    @GetMapping("/search_bill")
    @ResponseBody
    public List<Order> search_bill(@RequestParam("pageNum")Integer pageNum, @RequestParam("pageSize")Integer pageSize,int userid){

        return orderservice.search_bill(userid);
    }


    /**
     * 删除账单
     * @param orderid
     * @return
     */
    @PostMapping("/delete_bill")
    @ResponseBody
    public int delete_bill(int orderid){
        return orderservice.delete_bill(orderid);
    }





}
