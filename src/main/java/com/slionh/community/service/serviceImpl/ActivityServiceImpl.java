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
        ActivityExample activityExample=new ActivityExample();
        activityExample.setOrderByClause("starttime desc");
        List<Activity> list = activityMapper.selectByExample(activityExample);
        List<Activity> activities=new ArrayList<Activity>();
        for(Activity activity:list){
            activity.setPosition(communityMapper.selectByPrimaryKey(activity.getCommunityid()).getName());
            activities.add(activity);
        }
        return activities;
    }

    @Override
    public List<Activity> listActivityAndPosition() {
        ActivityExample activityExample=new ActivityExample();
        activityExample.setOrderByClause("starttime desc");
        List<Activity> list = activityMapper.selectByExample(activityExample);
        return list;
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

    @Override
    public Integer getActivityScoreByUser(Integer userId, Integer activityId) {
        ActivitymemberExample activitymemberExample=new ActivitymemberExample();
        activitymemberExample.createCriteria().andActivityidEqualTo(activityId).andUseridEqualTo(userId);
        List<Activitymember> list = activitymemberMapper.selectByExample(activitymemberExample);
        if (list.size()>0){
            return list.get(0).getScore();
        }
        return null;
    }

    @Override
    public Integer getActivityScoreAvg(Integer activityId) {
        ActivitymemberExample activitymemberExample=new ActivitymemberExample();
        activitymemberExample.createCriteria().andActivityidEqualTo(activityId);
        List<Activitymember> list = activitymemberMapper.selectByExample(activitymemberExample);
        Integer scoreSum=0;
        for (Activitymember activitymember:list){
            System.out.println(list.toString());
            if (activitymember.getScore()==null)
                break;
            scoreSum = scoreSum + activitymember.getScore();
        }
        if (scoreSum==0){
            return 0;
        }else{
//            System.out.println(scoreSum);
//            System.out.println(list.size());
//            System.out.println(scoreSum/list.size());
//            System.out.println(Math.round((float)scoreSum/list.size()));
            return Math.round((float)scoreSum/list.size());
        }

    }

    @Override
    public Integer setActivityScore(Activitymember activitymember) {
        ActivitymemberExample activitymemberExample=new ActivitymemberExample();
        activitymemberExample.createCriteria().andActivityidEqualTo(activitymember.getActivityid()).andUseridEqualTo(activitymember.getUserid());
        List<Activitymember> list=activitymemberMapper.selectByExample(activitymemberExample);
        if (list.size()==0){
            return activitymemberMapper.insert(activitymember);
        }else{
            activitymember.setIdactivitymember(list.get(0).getIdactivitymember());
            return activitymemberMapper.updateByPrimaryKey(activitymember);
        }
    }

    @Override
    public List<Activity> listUsersActivity(Integer userId) {
        ActivitymemberExample activitymemberExample=new ActivitymemberExample();
        activitymemberExample.createCriteria().andUseridEqualTo(userId);
        List<Activitymember> list =  activitymemberMapper.selectByExample(activitymemberExample);
        List<Activity> join = new ArrayList<Activity>();
        List<Activity> joined = new ArrayList<Activity>();
        for (Activitymember activitymember:list){
            join.add(activityMapper.selectByPrimaryKey(activitymember.getActivityid()));
        }
//        for(Activity activity:join){
//            activity.setPosition(communityMapper.selectByPrimaryKey(activity.getCommunityid()).getName());
//            joined.add(activity);
//        }
        return joined;
    }

    @Override
    public Integer getActivityAmountByUserId(Integer userId) {
        ActivitymemberExample activitymemberExample=new ActivitymemberExample();
        activitymemberExample.createCriteria().andUseridEqualTo(userId);

        return activitymemberMapper.countByExample(activitymemberExample);
    }

    @Override
    public Integer getReferenceJoinAmountByUserId(Integer userId, Integer communityId) {
        ActivitymemberExample activitymemberExample=new ActivitymemberExample();

        activitymemberExample.createCriteria().andUseridEqualTo(userId);
        List<Activitymember> activitymembers=activitymemberMapper.selectByExample(activitymemberExample);

        ActivityExample activityExample=new ActivityExample();
        activityExample.createCriteria().andCommunityidEqualTo(communityId).andMandatoryEqualTo(1);
        List<Activity> activities=activityMapper.selectByExample(activityExample);

        int amount=0;
        for (Activity activity:activities){
            for (Activitymember activitymember:activitymembers){
                if (activity.getIdactivity()==activitymember.getActivityid()){
                    amount++;
                    break;
                }
            }
        }

        return amount;
    }

    @Override
    public Integer getCommunityReferenceAmount(Integer communityId) {
        ActivityExample activityExample=new ActivityExample();
        activityExample.createCriteria().andCommunityidEqualTo(communityId).andMandatoryEqualTo(1);
        return activityMapper.countByExample(activityExample);
    }

    @Override
    public List<User> listActivityUsers(Integer activityId) {
        ActivitymemberExample activitymemberExample=new ActivitymemberExample();
        activitymemberExample.createCriteria().andActivityidEqualTo(activityId);
        List<Activitymember> activitymembers=activitymemberMapper.selectByExample(activitymemberExample);

        List<User> users=new ArrayList<User>();
        for (Activitymember activitymember:activitymembers){
            users.add(userMapper.selectByPrimaryKey(activitymember.getUserid()));
        }
        return users;
    }


}
