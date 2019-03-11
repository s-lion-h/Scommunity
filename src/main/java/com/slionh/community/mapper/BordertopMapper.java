package com.slionh.community.mapper;

import com.slionh.community.entity.Bordertop;
import com.slionh.community.entity.BordertopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BordertopMapper {
    int countByExample(BordertopExample example);

    int deleteByExample(BordertopExample example);

    int deleteByPrimaryKey(Integer idbordertop);

    int insert(Bordertop record);

    int insertSelective(Bordertop record);

    List<Bordertop> selectByExample(BordertopExample example);

    Bordertop selectByPrimaryKey(Integer idbordertop);

    int updateByExampleSelective(@Param("record") Bordertop record, @Param("example") BordertopExample example);

    int updateByExample(@Param("record") Bordertop record, @Param("example") BordertopExample example);

    int updateByPrimaryKeySelective(Bordertop record);

    int updateByPrimaryKey(Bordertop record);
}