package com.example.service;

import com.example.pojo.Transunit;
import com.example.utils.Returnobj;
import org.springframework.stereotype.Service;

import java.util.List;



public interface Transunitservice {


    List<Returnobj<Transunit>> list_morethanrest(int rest);

    int update_rest(int transid,int rest);

}
