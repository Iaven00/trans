package com.yufop.tran.service.impl;

import com.yufop.tran.mapper.OrderMapper;
import com.yufop.tran.pojo.table.Order;
import com.yufop.tran.pojo.table.OrderExample;
import com.yufop.tran.service.OrderService;
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
}
