package com.example.service.impl;

import com.example.mapper.RecordsMapper;
import com.example.pojo.Records;
import com.example.pojo.RecordsExample;
import com.example.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.example.utils.Global.*;

@Service
public class RecordServiceImpl implements RecordService {


    @Autowired
    RecordsMapper recordsMapper;


    @Override
    public List<Records> getRecList(int ordid) {
        RecordsExample recordsExample = new RecordsExample();
        recordsExample.setOrderByClause("time");
        recordsExample.createCriteria().andOrderidEqualTo(ordid);
        return recordsMapper.selectByExample(recordsExample);
    }

    @Override
    public int insert(int ordid, String state) {
        Records records = new Records();
        records.setOrderid(ordid);
        if(state.compareTo(Unshipped)==0){
            records.setContent("已创建,代发货");
        }
        else if(state.compareTo(Shipped)==0){
            records.setContent("已发货，运输中");
        }
        else if(state.compareTo(Delivered)==0){
            records.setContent("已签收，待领取");
        }
        else if(state.compareTo(FINISH)==0){
            records.setContent("订单已完成");
        }
        records.setTime(new Date());
        return recordsMapper.insertSelective(records);
    }
}
