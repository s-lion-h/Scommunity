package com.slionh.community.controller;

import com.slionh.community.entity.Activity;
import com.slionh.community.entity.Community;
import com.slionh.community.entity.Member;
import com.slionh.community.entity.User;
import com.slionh.community.mapper.ActivityMapper;
import com.slionh.community.mapper.MemberMapper;
import com.slionh.community.service.ActivityService;
import com.slionh.community.service.CommunityService;
import com.slionh.community.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/*
 * Create by s lion h on 2019/3/7
 */
@Controller
public class PresidentController {
    @Autowired
    private CommunityService communityService;
    @Autowired
    private ActivityService activityService;
    @Autowired
    private MemberService memberService;
    @RequestMapping("description")
    public ModelAndView toDescription(ModelAndView modelAndView, HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("loginUser");
        if (user==null){
            System.out.println("没有登陆，返回主页");
            return null;
        }else{
            modelAndView.setViewName("president/description");
            Community community=communityService.getCommunityByPresidentId(user.getIduser());
            modelAndView.addObject("community",community);
            request.getSession().setAttribute("community",community);
            return modelAndView;
        }

    }

    @RequestMapping("activities")
    public ModelAndView toActivities(HttpServletRequest request,ModelAndView modelAndView){
        User user= (User) request.getSession().getAttribute("loginUser");
        if (user==null){
//            未登录跳转首页
            System.out.println("CommunityController : not sign in , return index");
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }else {
            Community community= (Community) request.getSession().getAttribute("community");
            modelAndView.setViewName("president/activities");
            List<Activity> list= activityService.listCommunityActivity(community.getIdcommunity());
            modelAndView.addObject("activities",list);
            HashMap hashMap=new HashMap();
            HashMap amount = new HashMap();
            for (Activity activity:list){
                amount.put(activity.getIdactivity(),activityService.getAmountByActivity(activity.getIdactivity()));
                if (activity.getEndtime().getTime()>new Date().getTime()){
                    hashMap.put(activity.getIdactivity(),true);
                }else {
                    hashMap.put(activity.getIdactivity(),false);
                }
            }
            modelAndView.addObject("endStatus",hashMap);
            modelAndView.addObject("amount",amount);


            return modelAndView;
        }
    }

    @RequestMapping("memberApply")
    public ModelAndView toMemberApply(ModelAndView modelAndView,HttpServletRequest request){
        Community community= (Community) request.getSession().getAttribute("community");

        modelAndView.setViewName("president/memberApply");
        modelAndView.addObject("users",memberService.listCommunityApply(community.getIdcommunity()));
        return modelAndView;
    }
    @RequestMapping("addActivity")
    public String toAddActivity(){
        return "president/addActivity";
    }

    @RequestMapping("members")
    public ModelAndView toMembers(ModelAndView modelAndView,HttpServletRequest request){
        Community community = (Community) request.getSession().getAttribute("community");

        modelAndView.setViewName("president/members");

        List<User> list=memberService.listCommunityMember(community.getIdcommunity());
        modelAndView.addObject("members",list);

//        System.out.println("总会议："+activityService.getCommunityReferenceAmount(community.getIdcommunity()));
        int total=activityService.getCommunityReferenceAmount(community.getIdcommunity());
        HashMap joins=new HashMap();
        HashMap absences=new HashMap();

        for (User user:list){
//            System.out.println(user.getIduser()+"参与活动总数："+activityService.getActivityAmountByUserId(user.getIduser())+"参加会议数量："+activityService.getReferenceJoinAmountByUserId(user.getIduser(),community.getIdcommunity()));
            joins.put(user.getIduser(),activityService.getActivityAmountByUserId(user.getIduser()));
            absences.put(user.getIduser(),total-activityService.getReferenceJoinAmountByUserId(user.getIduser(),community.getIdcommunity()));
        }
        modelAndView.addObject("joins",joins);
        modelAndView.addObject("absences",absences);
        modelAndView.addObject("total",total);

        return modelAndView;
    }

    @RequestMapping("activityMembers")
    public ModelAndView activityMembers(ModelAndView modelAndView,Integer activityId,HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("loginUser");
        if (user==null){
//            未登录跳转首页
            System.out.println("CommunityController : not sign in , return index");
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }

        Community community = (Community) request.getSession().getAttribute("community");

        modelAndView.setViewName("activityMembers");

        modelAndView.addObject("amount",activityService.getAmountByActivity(activityId));
        modelAndView.addObject("generalScore",activityService.getActivityScoreAvg(activityId));
        modelAndView.addObject("activity",activityService.getActivity(activityId));
        modelAndView.addObject("members",activityService.listActivityUsers(activityId));
//        modelAndView

        return modelAndView;
    }
}
