package com.slionh.community.controller;

import com.slionh.community.entity.Community;
import com.slionh.community.entity.Webdescription;
import com.slionh.community.mapper.NewsMapper;
import com.slionh.community.service.BaseMsgService;
import com.slionh.community.service.CommunityService;
import com.slionh.community.service.NewsService;
import com.slionh.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

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
        modelAndView.setViewName("manage/communities");
        modelAndView.addObject("communities",communityService.listCommunity());
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
