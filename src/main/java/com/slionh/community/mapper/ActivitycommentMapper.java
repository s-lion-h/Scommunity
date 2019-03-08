package com.slionh.community.mapper;

import com.slionh.community.entity.Activitycomment;
import com.slionh.community.entity.ActivitycommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivitycommentMapper {
    int countByExample(ActivitycommentExample example);

    int deleteByExample(ActivitycommentExample example);

    int deleteByPrimaryKey(Integer idactivitycomment);

    int insert(Activitycomment record);

    int insertSelective(Activitycomment record);

    List<Activitycomment> selectByExample(ActivitycommentExample example);

    Activitycomment selectByPrimaryKey(Integer idactivitycomment);

    int updateByExampleSelective(@Param("record") Activitycomment record, @Param("example") ActivitycommentExample example);

    int updateByExample(@Param("record") Activitycomment record, @Param("example") ActivitycommentExample example);

    int updateByPrimaryKeySelective(Activitycomment record);

    int updateByPrimaryKey(Activitycomment record);
}