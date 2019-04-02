package com.slionh.community.controller;

import com.slionh.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        if(email==null||email.equals(""))
            return 3;
        if (checkEmailFormat(email)){
            return userService.emailIsUsed(email);
        }else{
//            邮箱格式错误
            return 2;
        }
    }

    private boolean checkEmailFormat(String content){
        /*
         * " \w"：匹配字母、数字、下划线。等价于'[A-Za-z0-9_]'。
         * "|"  : 或的意思，就是二选一
         * "*" : 出现0次或者多次
         * "+" : 出现1次或者多次
         * "{n,m}" : 至少出现n个，最多出现m个
         * "$" : 以前面的字符结束
         */
        String REGEX="^\\w+((-\\w+)|(\\.\\w+))*@\\w+(\\.\\w{2,3}){1,3}$";
        Pattern p = Pattern.compile(REGEX);
        Matcher matcher=p.matcher(content);

        return matcher.matches();
    }
}
