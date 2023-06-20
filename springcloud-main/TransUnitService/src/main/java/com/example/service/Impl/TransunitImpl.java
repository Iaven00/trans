package com.example.service.Impl;


import com.example.mapper.CompanyMapper;
import com.example.mapper.TransunitMapper;
import com.example.pojo.Transunit;

import com.example.pojo.TransunitExample;

import com.example.service.Transunitservice;
import com.example.utils.Returnobj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransunitImpl implements Transunitservice {

    @Autowired
    TransunitMapper transunitMapper;

    @Autowired
    CompanyMapper companyMapper;

    @Override
    public List<Returnobj<Transunit>> list_morethanrest(int rest) {



        // 获取所有存在运输资源的公司id  transunits
        List<Transunit> transunits = transunitMapper.listBycompanyid(rest);


        //返回类returnobjs
        List<Returnobj<Transunit>> returnobjs = new ArrayList<>();


        //获取所有运输资源大于等于rest的车队transunits1
        TransunitExample transunitExample = new TransunitExample();
        transunitExample.createCriteria().andRestGreaterThanOrEqualTo(rest);
        List<Transunit> transunits1 = transunitMapper.selectByExample(transunitExample);


        for(int i=0;i<transunits.size();i++){
            List<Transunit> transunits2 = new ArrayList<>();
            for(int j=0;j<transunits1.size();){
                if(transunits1.get(j).getCompanyid().equals(transunits.get(i).getCompanyid()) ){
                    transunits2.add(transunits1.get(j));
                    transunits1.remove(j);
                    continue;
                }
                j++;
            }
            Returnobj<Transunit> obj = new Returnobj<>(companyMapper.selectByPrimaryKey(transunits.get(i).getCompanyid()).getName(),transunits2);
            returnobjs.add(obj);
        }
        return returnobjs;
    }

    @Override
    public int update_rest(int transid, int rest) {
        Transunit transunit = transunitMapper.selectByPrimaryKey(transid);
        int m = transunit.getRest()-rest;
        if(m>=0){
            transunit.setRest(m);
            return transunitMapper.updateByPrimaryKeySelective(transunit);
        }
        return 0;
    }
}
