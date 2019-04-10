package com.slionh.community.controller;

import com.slionh.community.entity.Community;
import com.slionh.community.entity.Webdescription;
import com.slionh.community.mapper.NewsMapper;
import com.slionh.community.service.*;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/*
 * Create by s lion h on 2019/3/7
 */
@Controller
public class ManageController {
    @Autowired
    private NewsService newsService;
    @Autowired
    private BaseMsgService baseMsgService;
    @Autowired
    private CommunityService communityService;
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;

    @RequestMapping("addNotice")
    public String toAddNotice(){
        return "manage/addNotice";

    }

    @RequestMapping("manageNews")
    public ModelAndView toManageNews(ModelAndView modelAndView){
        modelAndView.setViewName("manage/manageNews");
        modelAndView.addObject("newsList",newsService.listNews());
        return modelAndView;

    }

    @RequestMapping("manageBase")
    public ModelAndView toManageBase(ModelAndView modelAndView){
        modelAndView.setViewName("manage/manageBase");
        modelAndView.addObject("description",baseMsgService.getWebDescription());
        return modelAndView;

    }

    @RequestMapping("communities")
    public ModelAndView toCommunities(ModelAndView modelAndView){
        HashMap memberMap=new HashMap();
        HashMap activityMap=new HashMap();
        modelAndView.setViewName("manage/communities");
        List<Community> communities=communityService.listCommunity();
        for (Community community:communities){
            memberMap.put(community.getIdcommunity(),commentService.getCommunityMembersAmount(community.getIdcommunity()));
            activityMap.put(community.getIdcommunity(),commentService.getCommunityActivitiesAmount(community.getIdcommunity()));
        }
        modelAndView.addObject("communities",communities);
        modelAndView.addObject("memberMap",memberMap);
        modelAndView.addObject("activityMap",activityMap);

        return modelAndView;
    }

    @RequestMapping("manageUser")
    public ModelAndView toManageUser(ModelAndView modelAndView){
        modelAndView.setViewName("manage/manageUser");

        modelAndView.addObject("userList",userService.listUser(null));
        return modelAndView;
    }

    @RequestMapping("addCommunity")
    public String toAddCommunity(){
        return "manage/addCommunity";
    }

    @PostMapping("updateBase")
    public String updateBase(Webdescription webdescription){
        webdescription.setIdwebdescription(1);
        baseMsgService.updateWebDescription(webdescription);
        return "redirect:/admin";
    }
    @PostMapping("updateBase2")
    @ResponseBody
    public String updateBase2(Webdescription webdescription,ModelAndView modelAndView){
        webdescription.setIdwebdescription(1);
        baseMsgService.updateWebDescription(webdescription);
//        modelAndView.setViewName("manage/manageBase");
//        modelAndView.addObject("description",baseMsgService.getWebDescription());
        return "success";
//        return "manage/manageBase";
    }
    @RequestMapping("getCommunity")
    @ResponseBody
    public Community getCommunity(Integer id){
        return communityService.getCommunity(id);
    }

    @RequestMapping("updateCommunity")
    public String updateCommunity(Community community){
        System.out.println(community);
        communityService.updateCommunity(community);
        return "redirect:admin";
    }
}
