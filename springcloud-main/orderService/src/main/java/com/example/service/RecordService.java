package com.example.service;

import com.example.pojo.Records;

import java.util.List;

public interface RecordService {


    //获取订单的所有状态
    List<Records> getRecList(int ordid);



    //更新状态
    int insert(int ordid,String state);




}
