package com.iaven.service;




import com.iaven.pojo.table.Order;


import java.util.List;


public interface OrderService {


    List<Order> list_orders();


    List<Order> list_sporders(String phone);


    List<Order> list_rporders(String phone);

    int add_Order(Order order);

    int delete_order(int order_id);

    int change_state(int orderId, String state);

}
