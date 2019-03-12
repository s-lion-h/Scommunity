package com.slionh.community.service;

import com.slionh.community.entity.*;

import java.util.List;

/*
 * Create by s lion h on 2019/3/7
 */
public interface ActivityService {
    Integer addActivity(Activity activity);
    List<Activity> listCommunityActivity(Integer communityId);
    List<Activity> listActivity();
    List<Activity> listActivity(Integer num);
    Activity getActivity(Integer id);
    Community getCommunityByActivityId(Integer id);
    List<Activitycomment> getCommentsByActivityId(Integer id);
    List<User> listCommentSUserById(Integer activityId);
    List<User> listCommentsUserByIdForSwitch(Integer activityId);
    Integer deleteActivity(Integer activityId);
    Integer updateActivity(Activity activityId);
    Integer getAmountByActivity(Integer activityId);
    Integer joinActivity(Integer userId,Integer activityId);
    Integer exitActivity(Integer userId,Integer activityId);
    Integer getActivityMemberStatus(Integer userId,Integer activityId);
    Integer getActivityScoreByUser(Integer userId,Integer activityId);
    Integer getActivityScoreAvg(Integer activityId);
    Integer setActivityScore(Activitymember activitymember);
}
