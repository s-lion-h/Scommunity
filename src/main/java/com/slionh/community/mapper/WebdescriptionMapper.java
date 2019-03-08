package com.slionh.community.mapper;

import com.slionh.community.entity.Webdescription;
import com.slionh.community.entity.WebdescriptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WebdescriptionMapper {
    int countByExample(WebdescriptionExample example);

    int deleteByExample(WebdescriptionExample example);

    int deleteByPrimaryKey(Integer idwebdescription);

    int insert(Webdescription record);

    int insertSelective(Webdescription record);

    List<Webdescription> selectByExample(WebdescriptionExample example);

    Webdescription selectByPrimaryKey(Integer idwebdescription);

    int updateByExampleSelective(@Param("record") Webdescription record, @Param("example") WebdescriptionExample example);

    int updateByExample(@Param("record") Webdescription record, @Param("example") WebdescriptionExample example);

    int updateByPrimaryKeySelective(Webdescription record);

    int updateByPrimaryKey(Webdescription record);
}