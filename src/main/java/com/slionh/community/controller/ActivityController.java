package com.slionh.community.controller;

import com.slionh.community.entity.Activity;
import com.slionh.community.entity.Activitymember;
import com.slionh.community.entity.Community;
import com.slionh.community.entity.User;
import com.slionh.community.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Create by s lion h on 2019/3/7
 */
@Controller
public class ActivityController {
    @Autowired
    private ActivityService activityService;
    private SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @PostMapping("addPrecidentActivity")
    public String addPrecidentActivity(HttpServletRequest request, Activity activity, String start, String end) throws ParseException {
        User user= (User) request.getSession().getAttribute("loginUser");
        if (user==null){
//            未登录跳转首页
            System.out.println("CommunityController : not sign in , return index");
            return "redirect:/";
        }else {
            Community community= (Community) request.getSession().getAttribute("community");

            activity.setStarttime(simpleDateFormat.parse(start));
            activity.setEndtime(simpleDateFormat.parse(end));
            activity.setCommunityid(community.getIdcommunity());
            System.out.println(activity.toString());
            activityService.addActivity(activity);

            return "redirect:/president";
        }
    }

    @RequestMapping("activityDetail")
    public ModelAndView activityDetail(ModelAndView modelAndView,HttpServletRequest request,Integer activityId){
        User user= (User) request.getSession().getAttribute("loginUser");
        if (user==null){
            modelAndView.setViewName("redirect:/");
            System.out.println("没有登陆，返回主页");
            return modelAndView;
        }else{
            modelAndView.addObject("status", activityService.getActivityMemberStatus(user.getIduser(), activityId));
            modelAndView.addObject("myScore", activityService.getActivityScoreByUser(user.getIduser(), activityId));

        }
        modelAndView.setViewName("activityDetail");
        if (activityService.getActivity(activityId).getEndtime().getTime()>new Date().getTime()){
            modelAndView.addObject("isTimeout",true);
        }else {
            modelAndView.addObject("isTimeout",false);
        }
        modelAndView.addObject("community",activityService.getCommunityByActivityId(activityId));
        modelAndView.addObject("amount",activityService.getAmountByActivity(activityId));
        modelAndView.addObject("activity",activityService.getActivity(activityId));
        modelAndView.addObject("comments",activityService.getCommentsByActivityId(activityId));
//        modelAndView.addObject("userList",activityService.listCommentSUserById(activityId));
        modelAndView.addObject("users",activityService.listCommentsUserByIdForSwitch(activityId));
        modelAndView.addObject("generalScore",activityService.getActivityScoreAvg(activityId));


        return modelAndView;
    }
    @PostMapping("getActivity")
    @ResponseBody
    public Activity getActivity(Integer id){
        return activityService.getActivity(id);

    }
    @RequestMapping("deleteActivityId")
    public String deleteActivityId(Integer id){
        activityService.deleteActivity(id);
        return "redirect:/president";
    }

    @PostMapping("updateActivity")
    public String updateActivity(Activity activity){
        activityService.updateActivity(activity);
        return "redirect:/president";
    }

    @RequestMapping("joinActivity")
    public String updateActivity(Integer activityId,HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("loginUser");
        activityService.joinActivity(user.getIduser(),activityId);
        return "redirect:/activityDetail?activityId="+activityId;
    }

    @RequestMapping("exitActivity")
    public String exitActivity(Integer activityId,HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("loginUser");
        activityService.exitActivity(user.getIduser(),activityId);
        return "redirect:/activityDetail?activityId="+activityId;
    }

    @PostMapping("setActivityScore")
    public String setActivityScore(Activitymember activitymember, HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("loginUser");
        if (user==null)
            return "redirect:/";

        activitymember.setUserid(user.getIduser());
        activityService.setActivityScore(activitymember);
        return "redirect:/activityDetail?activityId="+activitymember.getActivityid();
    }
}
