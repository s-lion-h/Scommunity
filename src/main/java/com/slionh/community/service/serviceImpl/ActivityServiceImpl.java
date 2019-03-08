package com.slionh.community.service.serviceImpl;

import com.slionh.community.entity.*;
import com.slionh.community.mapper.ActivityMapper;
import com.slionh.community.mapper.ActivitycommentMapper;
import com.slionh.community.mapper.CommunityMapper;
import com.slionh.community.mapper.UserMapper;
import com.slionh.community.service.ActivityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/*
 * Create by s lion h on 2019/3/7
 */
@Service
public class ActivityServiceImpl implements ActivityService {
    @Resource
    private ActivityMapper activityMapper;
    @Resource
    private CommunityMapper communityMapper;
    @Resource
    private ActivitycommentMapper activitycommentMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public Integer addActivity(Activity activity) {
        return activityMapper.insert(activity);
    }

    @Override
    public List<Activity> listCommunityActivity(Integer communityId) {
        ActivityExample activityExample=new ActivityExample();
        activityExample.createCriteria().andCommunityidEqualTo(communityId);

        return activityMapper.selectByExample(activityExample);
    }

    @Override
    public List<Activity> listActivity() {
        List<Activity> list = activityMapper.selectByExample(new ActivityExample());
        List<Activity> activities=new ArrayList<Activity>();
        for(Activity activity:list){
            activity.setPosition(communityMapper.selectByPrimaryKey(activity.getCommunityid()).getName());
            activities.add(activity);
        }
        return activities;
    }

    @Override
    public List<Activity> listActivity(Integer num) {
        return activityMapper.selectByExample(new ActivityExample());
    }

    @Override
    public Activity getActivity(Integer id) {
        return activityMapper.selectByPrimaryKey(id);
    }

    @Override
    public Community getCommunityByActivityId(Integer id) {
        Integer communityId = activityMapper.selectByPrimaryKey(id).getCommunityid();
        return communityMapper.selectByPrimaryKey(communityId);
    }

    @Override
    public List<Activitycomment> getCommentsByActivityId(Integer id) {
        ActivitycommentExample activitycommentExample=new ActivitycommentExample();
        activitycommentExample.createCriteria().andActivityidEqualTo(id);
        return activitycommentMapper.selectByExample(activitycommentExample);
    }

    @Override
    public List<User> listCommentSUserById(Integer activityId) {
        ActivitycommentExample activitycommentExample=new ActivitycommentExample();
        activitycommentExample.createCriteria().andActivityidEqualTo(activityId);
        List<User> userList=new ArrayList<User>();
        for (Activitycomment activitycomment:activitycommentMapper.selectByExample(activitycommentExample)){
                userList.add(userMapper.selectByPrimaryKey(activitycomment.getUserid()));
        }
        return userList;
    }

    @Override
    public List<User> listCommentsUserByIdForSwitch(Integer activityId) {
        ActivitycommentExample activitycommentExample=new ActivitycommentExample();
        activitycommentExample.createCriteria().andActivityidEqualTo(activityId);
        List<User> userList=new ArrayList<User>();
        List<Integer> users=new ArrayList<Integer>();
        for (Activitycomment activitycomment:activitycommentMapper.selectByExample(activitycommentExample)){
            if (!users.contains(activitycomment.getUserid())){
                users.add(activitycomment.getUserid());
                userList.add(userMapper.selectByPrimaryKey(activitycomment.getUserid()));
            }
        }
        return userList;
    }

    @Override
    public Integer deleteActivity(Integer activityId) {
        return activityMapper.deleteByPrimaryKey(activityId);
    }
}
