package com.slionh.community.service.serviceImpl;

import com.slionh.community.entity.Activitycomment;
import com.slionh.community.entity.Newscomment;
import com.slionh.community.mapper.ActivitycommentMapper;
import com.slionh.community.mapper.NewscommentMapper;
import com.slionh.community.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/*
 * Create by s lion h on 2019/3/8
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    private ActivitycommentMapper activitycommentMapper;
    @Resource
    private NewscommentMapper newscommentMapper;

    @Override
    public Integer addActivityComment(Activitycomment activitycomment) {
        return activitycommentMapper.insert(activitycomment);
    }

    @Override
    public Integer addNewsComment(Newscomment newscomment) {
        return newscommentMapper.insert(newscomment);
    }
}
