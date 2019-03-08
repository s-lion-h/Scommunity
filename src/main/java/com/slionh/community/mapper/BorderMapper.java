package com.slionh.community.mapper;

import com.slionh.community.entity.Border;
import com.slionh.community.entity.BorderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BorderMapper {
    int countByExample(BorderExample example);

    int deleteByExample(BorderExample example);

    int deleteByPrimaryKey(Integer idborder);

    int insert(Border record);

    int insertSelective(Border record);

    List<Border> selectByExample(BorderExample example);

    Border selectByPrimaryKey(Integer idborder);

    int updateByExampleSelective(@Param("record") Border record, @Param("example") BorderExample example);

    int updateByExample(@Param("record") Border record, @Param("example") BorderExample example);

    int updateByPrimaryKeySelective(Border record);

    int updateByPrimaryKey(Border record);
}