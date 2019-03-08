package com.slionh.community.controller;

import com.slionh.community.entity.Community;
import com.slionh.community.entity.User;
import com.slionh.community.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/*
 * Create by s lion h on 2019/3/7
 */
@Controller
public class MemberController {
    @Autowired
    private MemberService memberService;

    @RequestMapping("joinCommunity")
    public String joinCommunity(Integer communityId,String description, HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("loginUser");
        memberService.addUserApply(user.getIduser(),communityId,description);
        return "redirect:/communityDetail?id="+communityId;


    }
    @RequestMapping("accessApply")
    public String accessApply(Integer uid,HttpServletRequest request){
        Community community= (Community) request.getSession().getAttribute("community");
        memberService.accessApply(uid, community.getIdcommunity());
        return "redirect:/president";

    }
}
