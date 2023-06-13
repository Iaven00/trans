package com.iaven.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.iaven.pojo.table.Order;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    /**
     * 列出用户的所有订单
     * @param pageNum
     * @param pageSize
     * @param userid
     * @return
     */
    @GetMapping("/list_order")
    @ResponseBody
    public PageInfo<Order> get_allrecords(@RequestParam("pageNum")Integer pageNum, @RequestParam("pageSize")Integer pageSize, int userid){
        PageHelper.startPage(pageNum,pageSize);

        /**TODO
         *
         */
        PageInfo<Order> pageInfo = new PageInfo<Order>();
        return pageInfo;
    }


    /**
     * 根据收件人姓名查询订单
     * @param pageNum
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("search_orderbyname")
    @ResponseBody
    public PageInfo<Order> get_recordsbyname(@RequestParam("pageNum")Integer pageNum, @RequestParam("pageSize")Integer pageSize,int userid,String name){
        PageHelper.startPage(pageNum,pageSize);

        /**TODO
         *
         */
        PageInfo<Order> pageInfo = new PageInfo<Order>();
        return pageInfo;
    }


    /**
     * 根据收获地址查询
     * @param pageNum
     * @param pageSize
     * @param userid
     * @param address
     * @return
     */
    @GetMapping("search_orderbyaddress")
    @ResponseBody
    public PageInfo<Order> get_recordsbyaddress(@RequestParam("pageNum")Integer pageNum, @RequestParam("pageSize")Integer pageSize,int userid,String address){
        PageHelper.startPage(pageNum,pageSize);

        /**TODO
         *
         */
        PageInfo<Order> pageInfo = new PageInfo<Order>();
        return pageInfo;
    }


    /**
     * 提交订单
     * @param order
     * @return
     */
    @GetMapping("submit_order")
    @ResponseBody
    public int order(Order order){

        /**TODO
         *
         */
        return 1;
    }


    /**
     * 撤销订单（退款）
     * @param orderid
     * @return
     */
    @GetMapping("revoke_order")
    @ResponseBody
    public int revoke(int orderid){

        /**TODO
         *
         */
        return 1;
    }

    /**
     * 查看用户账单
     * @param userid
     * @return
     */
    @GetMapping("search_bill")
    @ResponseBody
    public int search_bill(int userid){

        /**TODO
         *
         */
        return 1;
    }





}
