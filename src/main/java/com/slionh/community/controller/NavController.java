package com.slionh.community.controller;

import com.slionh.community.entity.User;
import com.slionh.community.mapper.NewsMapper;
import com.slionh.community.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/*
 * Create by s lion h on 2019/3/6
 */
@Controller
public class NavController {
    @Autowired
    private UserService userService;
    @Autowired
    private CommunityService communityService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private ActivityService activityService;
    @Autowired
    private BorderService borderService;


    @RequestMapping("/")
    public ModelAndView toIndex(HttpServletRequest request,ModelAndView modelAndView)
    {
        User user= (User) request.getSession().getAttribute("loginUser");
        if (user==null){
            modelAndView.setViewName("login");
            return modelAndView;
        }

        if (user.getLevel()==10){
            modelAndView.setViewName("redirect:/admin");
            return modelAndView;
        }else if (user.getLevel()==2){
            modelAndView.setViewName("redirect:/president");
            return modelAndView;
        }

        modelAndView.setViewName("index");
        modelAndView.addObject("activities",activityService.listActivity(4));
        modelAndView.addObject("communities", communityService.listCommunity(4));
        modelAndView.addObject("newses",newsService.listNews());

        return modelAndView;
    }

    @RequestMapping("/loginPage")
    public String toLoginPage(){
        return "login";
    }

    @RequestMapping("/register")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("/admin")
    public String toAdmin(HttpServletRequest request)
    {
        User user= (User) request.getSession().getAttribute("loginUser");
        if (user==null||user.getLevel()!=10){
            return "redirect:/";
        }
        return "admin";
    }

    @RequestMapping("/president")
    public ModelAndView toPresident(HttpServletRequest request,ModelAndView modelAndView)
    {
        User user= (User) request.getSession().getAttribute("loginUser");
        if (user==null){
            modelAndView.setViewName("redirect:/");
            System.out.println("没有登陆，返回主页");
            return modelAndView;
        }else{
            modelAndView.setViewName("president");
            return modelAndView;

        }
    }

    @RequestMapping("/news")
    public ModelAndView toNews(ModelAndView modelAndView){
        modelAndView.setViewName("news");
        modelAndView.addObject("newses",newsService.listNews());
        return modelAndView;
    }

    @RequestMapping("navActivity")
    public ModelAndView toNavActivity(ModelAndView modelAndView){
        modelAndView.setViewName("navActivity");
        modelAndView.addObject("activities",activityService.listActivity());

        return modelAndView;
    }

    @RequestMapping("navCommunity")
    public ModelAndView toNavCommunity(ModelAndView modelAndView ,HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("loginUser");

        if (user!=null){
            modelAndView.addObject("myCommunities", memberService.listUserJoined(user.getIduser()));
        }

        modelAndView.setViewName("navCommunity");
        modelAndView.addObject("communities", communityService.listCommunity());

        return modelAndView;
    }

//    待调整impl参数
    @RequestMapping("board")
    public ModelAndView toBoard(ModelAndView modelAndView,Integer page){
        modelAndView.setViewName("board");
        if (page==null){
            modelAndView.addObject("borders",borderService.listBorder(1));
            modelAndView.addObject("users",borderService.listBorderUser(1));
            modelAndView.addObject("borderTops",borderService.listBorderTop());
            modelAndView.addObject("borderTopUsers",borderService.listBorderTopUser());

        }else{
            modelAndView.addObject("borders",borderService.listBorder(page));
            modelAndView.addObject("users",borderService.listBorderUser(page));
            modelAndView.addObject("borderTops",borderService.listBorderTop());
            modelAndView.addObject("borderTopUsers",borderService.listBorderTopUser());
        }


        return modelAndView;
    }

    @RequestMapping("info")
    public ModelAndView toInfo(ModelAndView modelAndView,HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("loginUser");
        if (user!=null){
            modelAndView.addObject("myCommunities", memberService.listUserJoined(user.getIduser()));
        }else{
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }
        modelAndView.setViewName("info");
        return modelAndView;
    }
    @RequestMapping("userLogout")
    public String userLogout(HttpServletRequest request){
        System.out.println("logging out");
        request.getSession().invalidate();
        return "redirect:/";
    }
}
