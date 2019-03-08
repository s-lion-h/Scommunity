package com.slionh.community.controller;

import com.slionh.community.configuration.Configuration;
import com.slionh.community.entity.News;
import com.slionh.community.entity.User;
import com.slionh.community.service.NewsCommentService;
import com.slionh.community.service.NewsService;
import com.slionh.community.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/*
 * Create by s lion h on 2019/3/7
 */
@Controller
public class NewsController implements Configuration {
    @Autowired
    private NewsService newsService;
    @Autowired
    private NewsCommentService newsCommentService;

    @PostMapping("addNews")
    public String addNews(HttpServletRequest request,News news, @RequestParam("headImage") MultipartFile headImage) throws IOException {
        User user= (User) request.getSession().getAttribute("loginUser");
//        if (1==2){
        if (user==null){
//            未登录跳转首页
            System.out.println("CommunityController : not sign in , return index");
            return "redirect:/";
        }else {
            if (headImage.isEmpty()) {
                System.out.println("this change request have not image ");
            } else {
                System.out.println("ready to change head image");
                String filename = ImageUtil.saveImg(headImage, IMAGE_PATH);
                System.out.println("file save up success : " + filename);
                news.setImage("/image/"+filename);
            }
            news.setUserid(user.getIduser());
            newsService.addNews(news);

            return "redirect:/admin";
        }
    }
    @RequestMapping("getNews")
    @ResponseBody
    public News getNewss(Integer id){
        return newsService.getNews(id);
    }

    @RequestMapping("deleteNews")
    public String deleteNews(Integer id){
        newsService.deleteNews(id);
        return "redirect:/admin";
    }

    @RequestMapping("updateNews")
    public String updateNews(News news){
        newsService.updateNews(news);
        return "redirect:/admin";
    }

    @RequestMapping("newsDetail")
    public ModelAndView newsDetail(ModelAndView modelAndView,Integer newsId){
        modelAndView.setViewName("newsDetail");
        modelAndView.addObject("news",newsService.getNews(newsId));
        modelAndView.addObject("users",newsCommentService.listNewsCommentUsersByNewsId(newsId));
        modelAndView.addObject("comments",newsCommentService.listNewsCommentByNewsId(newsId));
        return modelAndView;

    }

}
