package com.slionh.community.controller;

import com.slionh.community.entity.Activitycomment;
import com.slionh.community.entity.Newscomment;
import com.slionh.community.entity.User;
import com.slionh.community.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/*
 * Create by s lion h on 2019/3/8
 */
@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("addComment")
    public String addComment(String comment, Integer activityId, HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("loginUser");
        if (user==null){
            return "redirect:/activityDetail?activityId="+activityId;
        }
        Activitycomment activitycomment=new Activitycomment();
        activitycomment.setActivityid(activityId);
        activitycomment.setContent(comment);
        activitycomment.setUserid(user.getIduser());
        commentService.addActivityComment(activitycomment);
        return "redirect:/activityDetail?activityId="+activityId;
    }
    @PostMapping("addNewsComment")
    public String addNewsComment(String comment, Integer newsId, HttpServletRequest request){
        User user= (User) request.getSession().getAttribute("loginUser");
        if (user==null){
            return "redirect:/newsDetail?newsId="+newsId;
        }
        Newscomment newscomment=new Newscomment();
        newscomment.setContent(comment);
        newscomment.setUserid(user.getIduser());
        newscomment.setNewsid(newsId);

        commentService.addNewsComment(newscomment);
        return "redirect:/newsDetail?newsId="+newsId;

    }
}
