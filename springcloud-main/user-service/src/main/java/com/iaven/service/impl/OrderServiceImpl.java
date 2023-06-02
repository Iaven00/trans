package com.iaven.service.impl;

import com.iaven.mapper.OrderMapper;
import com.iaven.pojo.table.Order;
import com.iaven.pojo.table.OrderExample;
import com.iaven.service.OrderService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@Repository
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;


    @Override
    public List<Order> list_orders() {
        return orderMapper.selectByExample(null);
    }

    @Override
    public List<Order> list_sporders(String phone) {
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andSendphoneEqualTo(phone);
        return orderMapper.selectByExample(orderExample);
    }

    @Override
    public List<Order> list_rporders(String phone) {
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andRecphoneEqualTo(phone);
        return orderMapper.selectByExample(orderExample);
    }

    @Override
    public int add_Order(Order order) {


        return orderMapper.insertSelective(order);

    }

    @Override
    public int delete_order(int order_id) {
        return orderMapper.deleteByPrimaryKey(order_id);
    }

    @Override
    public int change_state(int orderId, String state) {
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andIdEqualTo(orderId);
        Order order = new Order();
        order.setState(state);
        if(orderMapper.updateByExampleSelective(order,orderExample)>0){
            return 1;
        }
        return 0;
    }
}
