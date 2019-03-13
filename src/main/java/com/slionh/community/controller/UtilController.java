package com.slionh.community.controller;

import com.slionh.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * Create by s lion h on 2019/3/13
 */
@Controller
public class UtilController {
    @Autowired
    private UserService userService;
    @RequestMapping("/emailIsUsed")
    @ResponseBody
    public Integer emailIsUsed(String email){
        return userService.emailIsUsed(email);
    }

}
