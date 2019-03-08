package com.slionh.community.controller;

import com.slionh.community.entity.Activity;
import com.slionh.community.entity.Community;
import com.slionh.community.entity.Member;
import com.slionh.community.entity.User;
import com.slionh.community.mapper.MemberMapper;
import com.slionh.community.service.ActivityService;
import com.slionh.community.service.CommunityService;
import com.slionh.community.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

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
            modelAndView.addObject("activities",activityService.listCommunityActivity(community.getIdcommunity()));

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
        modelAndView.addObject("members",memberService.listCommunityMember(community.getIdcommunity()));

        return modelAndView;
    }
}
