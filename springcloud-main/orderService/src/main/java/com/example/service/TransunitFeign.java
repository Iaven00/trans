package com.example.service;


import com.example.pojo.Transunit;
import com.example.utils.Returnobj;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Component
@FeignClient(value = "transunitservice")
public interface TransunitFeign {

    @RequestMapping(value = "/tran/morethanrest",method = RequestMethod.GET)
    List<Returnobj<Transunit>> list_morethanrest(@RequestParam(value = "rest")int rest);

    @RequestMapping(value = "/tran/update_rest",method = RequestMethod.POST)
    int updateRest(@RequestParam(value = "transid")int transid,@RequestParam(value = "rest")int rest);


}
