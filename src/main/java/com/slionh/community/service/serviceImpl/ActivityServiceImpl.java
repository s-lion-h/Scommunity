package com.slionh.community.service.serviceImpl;

import com.slionh.community.entity.*;
import com.slionh.community.mapper.*;
import com.slionh.community.service.ActivityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/*
 * Create by s lion h on 2019/3/7
 * status=1已参加
 * status=0未参加
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
    @Resource
    private ActivitymemberMapper activitymemberMapper;

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
//        return activityMapper.selectByExample(new ActivityExample());
        List<Activity> list = activityMapper.selectByExample(new ActivityExample());
        List<Activity> activities=new ArrayList<Activity>();
        for(Activity activity:list){
            if (activities.size()>4)
                return activities;
            activity.setPosition(communityMapper.selectByPrimaryKey(activity.getCommunityid()).getName());
            activities.add(activity);
        }
        return activities;
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

    @Override
    public Integer updateActivity(Activity activityId) {
        return activityMapper.updateByPrimaryKeySelective(activityId);
    }

    @Override
    public Integer getAmountByActivity(Integer activityId) {
        ActivitymemberExample activitymemberExample=new ActivitymemberExample();
        activitymemberExample.createCriteria().andActivityidEqualTo(activityId);
//        ActivityExample
        return activitymemberMapper.selectByExample(activitymemberExample).size();
    }

    @Override
    public Integer joinActivity(Integer userId, Integer activityId) {
        Activitymember activitymember=new Activitymember();
        activitymember.setUserid(userId);
        activitymember.setActivityid(activityId);

        return activitymemberMapper.insert(activitymember);
    }

    @Override
    public Integer exitActivity(Integer userId, Integer activityId) {
        ActivitymemberExample activitymemberExample=new ActivitymemberExample();
        activitymemberExample.createCriteria().andUseridEqualTo(userId).andActivityidEqualTo(activityId);

        return activitymemberMapper.deleteByExample(activitymemberExample);
    }

    @Override
    public Integer getActivityMemberStatus(Integer userId, Integer activityId) {
        ActivitymemberExample activitymemberExample=new ActivitymemberExample();
        activitymemberExample.createCriteria().andActivityidEqualTo(activityId).andUseridEqualTo(userId);
        if (activitymemberMapper.selectByExample(activitymemberExample).size()>0){
            return 1;
        }else{
            return 0;
        }
    }
}
