package com.slionh.community.controller;

import com.slionh.community.configuration.Configuration;
import com.slionh.community.entity.Activity;
import com.slionh.community.entity.Community;
import com.slionh.community.entity.User;
import com.slionh.community.service.ActivityService;
import com.slionh.community.service.CommunityService;
import com.slionh.community.service.MemberService;
import com.slionh.community.service.UserService;
import com.slionh.community.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/*
 * Create by s lion h on 2019/3/7
 */
@Controller
public class CommunityController implements Configuration {
    @Autowired
    private UserService userService;
    @Autowired
    private CommunityService communityService;
    @Autowired
    private ActivityService activityService;
    @Autowired
    private MemberService memberService;

    @PostMapping("addCommunity")
    public ModelAndView addCommunity(HttpServletRequest request, ModelAndView modelAndView, @RequestParam("headImage") MultipartFile headImage, Community community,User president) throws IOException {
        System.out.println(community.toString());
        System.out.println(president.toString());
        User user= (User) request.getSession().getAttribute("loginUser");
//        if (1==2){
        if (user==null){
//            未登录跳转首页
            modelAndView.setViewName("redirect:/");
            System.out.println("CommunityController : not sign in , return index");
            return modelAndView;
        }else {
            community.setPresident(userService.addPresident(president));
//            已经登陆用户直接可以提交contact
//            contact.setUserid(user.getId());
//            contactService.addContactObject(contact);

            if (headImage.isEmpty()) {
                System.out.println("this change request have not image ");
            } else {
                System.out.println("ready to change head image");
                String filename = ImageUtil.saveImg(headImage, IMAGE_PATH);
                System.out.println("file save up success : " + filename);
                community.setLogo("/image/"+filename);
            }
            communityService.addCommunity(community);

            modelAndView.setViewName("redirect:/admin");
            return modelAndView;
        }
    }

    @RequestMapping("deleteCommunity")
    public String deleteCommunity(Integer id){
        communityService.deleteCommunity(id);
        return "redirect:/admin";
    }

    @PostMapping("updateMyCommunity")
    public String updateCommunitySelective(Integer idCommunity,String introduction,@RequestParam("logo") MultipartFile logo,HttpServletRequest request) throws IOException {
        System.out.println("change community");
        User user= (User) request.getSession().getAttribute("loginUser");
        if (user==null){
//            未登录跳转首页
            System.out.println("CommunityController : not sign in , return index");
            return "redirect:/";
        }else {
            if (logo.isEmpty()){
                System.out.println("nothing change! ");
                communityService.updateCommunitySelective(idCommunity,introduction,null);
                return "redirect:/president";
            } else {


                System.out.println("ready to change head image");
                String filename = ImageUtil.saveImg(logo, IMAGE_PATH);
                System.out.println("file save up success : " + filename);
                String url = "/image/"+filename;
                communityService.updateCommunitySelective(idCommunity,introduction,url);

            }

            return "redirect:/president";
        }
    }


    @RequestMapping("communityDetail")
    public ModelAndView communityDetail(ModelAndView modelAndView,Integer id,HttpServletRequest request){
        modelAndView.setViewName("communityDetail");
        User user= (User) request.getSession().getAttribute("loginUser");
        if (user!=null){
            modelAndView.addObject("status",memberService.getUserCommunityStatus(user.getIduser(),id));
        }else{
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }

        Community community=communityService.getCommunity(id);
        modelAndView.addObject("community",community);

        modelAndView.addObject("activities",activityService.listCommunityActivity(id));
        modelAndView.addObject("president",userService.getInfo(community.getPresident()));

        if (user==null){
//            没有登陆只可以看基本的社团简介和社团活动列表
            return modelAndView;

        }else{
//            登陆，用户可以直接加入社团或者加入活动
            return modelAndView;
        }

    }

}
