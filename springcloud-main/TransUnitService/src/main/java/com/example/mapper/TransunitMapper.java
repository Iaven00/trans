package com.example.mapper;

import com.example.pojo.Transunit;
import com.example.pojo.TransunitExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface TransunitMapper {
    long countByExample(TransunitExample example);

    int deleteByExample(TransunitExample example);

    int deleteByPrimaryKey(Integer transunitid);

    int insert(Transunit record);

    int insertSelective(Transunit record);

    List<Transunit> selectByExample(TransunitExample example);

    Transunit selectByPrimaryKey(Integer transunitid);

    int updateByExampleSelective(@Param("record") Transunit record, @Param("example") TransunitExample example);

    int updateByExample(@Param("record") Transunit record, @Param("example") TransunitExample example);

    int updateByPrimaryKeySelective(Transunit record);

    int updateByPrimaryKey(Transunit record);

    List<Transunit> listBycompanyid(@Param("rest") int rest);
}