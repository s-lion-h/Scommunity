package com.slionh.community.controller;

import com.slionh.community.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 * Create by s lion h on 2019/4/6
 */
@Controller
public class MapController {
    @Autowired
    private ActivityService activityService;

    @RequestMapping("communityMap")
    public ModelAndView communityMap(ModelAndView modelAndView,Integer communityId){
//        空值时显示所有社团的活动地图，没有区分时间戳，是否有效，是否强制
        if (communityId==null){
            modelAndView.setViewName("communityMap");
            modelAndView.addObject("activities",activityService.listActivityAndPosition());
            return modelAndView;
        }
        modelAndView.setViewName("communityMap");
        modelAndView.addObject("activities",activityService.listCommunityActivity(communityId));

        return modelAndView;
    }
}
