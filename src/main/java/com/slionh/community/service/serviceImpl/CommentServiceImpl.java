package com.slionh.community.service.serviceImpl;

import com.slionh.community.entity.*;
import com.slionh.community.mapper.ActivityMapper;
import com.slionh.community.mapper.ActivitycommentMapper;
import com.slionh.community.mapper.MemberMapper;
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
    @Resource
    private ActivityMapper activityMapper;
    @Resource
    private MemberMapper memberMapper;


    @Override
    public Integer addActivityComment(Activitycomment activitycomment) {
        return activitycommentMapper.insert(activitycomment);
    }

    @Override
    public Integer addNewsComment(Newscomment newscomment) {
        return newscommentMapper.insert(newscomment);
    }

    @Override
    public Integer getCommunityMembersAmount(Integer communityId) {
        MemberExample memberExample=new MemberExample();
        memberExample.createCriteria().andCommunityidEqualTo(communityId);

        return memberMapper.countByExample(memberExample);
    }

    @Override
    public Integer getCommunityActivitiesAmount(Integer communityId) {
        ActivityExample activityExample=new ActivityExample();
        activityExample.createCriteria().andCommunityidEqualTo(communityId);

        return activityMapper.countByExample(activityExample);
    }
}
