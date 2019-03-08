package com.slionh.community.mapper;

import com.slionh.community.entity.Newscomment;
import com.slionh.community.entity.NewscommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NewscommentMapper {
    int countByExample(NewscommentExample example);

    int deleteByExample(NewscommentExample example);

    int deleteByPrimaryKey(Integer idnewscomment);

    int insert(Newscomment record);

    int insertSelective(Newscomment record);

    List<Newscomment> selectByExample(NewscommentExample example);

    Newscomment selectByPrimaryKey(Integer idnewscomment);

    int updateByExampleSelective(@Param("record") Newscomment record, @Param("example") NewscommentExample example);

    int updateByExample(@Param("record") Newscomment record, @Param("example") NewscommentExample example);

    int updateByPrimaryKeySelective(Newscomment record);

    int updateByPrimaryKey(Newscomment record);
}