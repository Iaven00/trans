package com.example.service;

import com.example.pojo.Order;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface orderService {


    //根据用户id查询订单
    List<Order> list_orders(int id);

    //根据收件人姓名列出所有订单
    List<Order> listbyrename(int id,String name);

    //根据收件人地址列出所有订单
    List<Order> listbyaddress(int id,String add);

    //选择物流公司提交订单
    int submit_order(Order order);

    //选择未发货的订单进行撤销
    int revoke_order(int orderid);

    //物流人员更新订单状态
    int update_state(int orderid,String state);

    //search_bill
    List<Order> search_bill(int userid);


    int delete_bill(int orderid);

    //更新transunitid
    int update_trans(int transid,int ordid);


    List<Order> list_all();

    List<Order> listBysp(String p);

    List<Order> listByrp(String p);

}
