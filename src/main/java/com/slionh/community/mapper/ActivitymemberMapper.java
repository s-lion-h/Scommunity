package com.slionh.community.mapper;

import com.slionh.community.entity.Activitymember;
import com.slionh.community.entity.ActivitymemberExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivitymemberMapper {
    int countByExample(ActivitymemberExample example);

    int deleteByExample(ActivitymemberExample example);

    int deleteByPrimaryKey(Integer idactivitymember);

    int insert(Activitymember record);

    int insertSelective(Activitymember record);

    List<Activitymember> selectByExample(ActivitymemberExample example);

    Activitymember selectByPrimaryKey(Integer idactivitymember);

    int updateByExampleSelective(@Param("record") Activitymember record, @Param("example") ActivitymemberExample example);

    int updateByExample(@Param("record") Activitymember record, @Param("example") ActivitymemberExample example);

    int updateByPrimaryKeySelective(Activitymember record);

    int updateByPrimaryKey(Activitymember record);
}