package com.slionh.community.controller;

import com.slionh.community.configuration.Configuration;
import com.slionh.community.entity.User;
import com.slionh.community.service.UserService;
import com.slionh.community.util.ImageUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * Create by s lion h on 2019/3/6
 */
@Controller
public class UserController implements Configuration {
    @Autowired
    private UserService userService;

    @RequestMapping("/userRegister")
    public String userRegister(javax.servlet.http.HttpServletRequest request, ModelAndView modelAndView, User user){
//        暂未考虑注册失败、注册重名的问题
//        level 1 = normal user
        user.setLevel(1);

        User loginUser = userService.register(user);
        request.getSession().setAttribute("loginUser",loginUser);

        System.out.println("register : "+user.toString());
        return "redirect:/";
    }


    @RequestMapping("/userLogin")
    @ResponseBody
    public ModelAndView userLogin(String email, String password, String remember, ModelAndView modelAndView, HttpServletResponse response, HttpServletRequest request){
//        System.out.println(email+password);
        User loginUser=userService.login(email, password);
        if (loginUser==null){
            modelAndView.setViewName("redirect:/");
            modelAndView.addObject("msg","error passport");
            return modelAndView;
        }else{
//            登陆成功
            request.getSession().setAttribute("loginUser",loginUser);

//                记住我
            if (remember!=null&&remember.equals("1")){
                request.getSession().setMaxInactiveInterval(60*60*24*3);

                Cookie cookie = new Cookie("JSESSIONID",request.getSession().getId());

                cookie.setMaxAge(60*60*24*3);//10分钟 ---- 时间设置为0代表删除该cookie
                cookie.setPath("/");//访问WEB16下的任何资源时都携带这个cookie

                response.addCookie(cookie);
            }
//            modelAndView.addObject("msg","login success");
            modelAndView.setViewName("redirect:/");
            return modelAndView;
        }

    }

    @PostMapping("changeHead")
    public String changeHead(@RequestParam("headImage") MultipartFile headImage, HttpServletRequest request) throws IOException {
        User user= (User) request.getSession().getAttribute("loginUser");
        if (user==null)
            return "redirect:/";
        if (headImage.isEmpty()) {
            System.out.println("this change request have not image ");
        } else {
            System.out.println("ready to change head image");
            String filename = ImageUtil.saveImg(headImage, IMAGE_PATH);
            System.out.println("file save up success : " + filename);
            user.setHead("/image/"+filename);
            userService.changeHead(user);

        }
        return "redirect:info";

    }

    @PostMapping("updateUser")
    public String updateUser(HttpServletRequest request,User user){
        System.out.println("updating user : "+user);
        User loginUser= (User) request.getSession().getAttribute("loginUser");
        if (user==null)
            return "redirect:/";

        user.setIduser(loginUser.getIduser());
        User updatedUser = userService.updateUserSelective(user);
        request.getSession().removeAttribute("loginUser");
        request.getSession().setAttribute("loginUser",updatedUser);
        return "redirect:/info";


    }

    @PostMapping("changeUser")
    public String changeUser(HttpServletRequest request,User user){
        System.out.println("changing user : "+user);

        User updatedUser = userService.updateUserSelective(user);
        return "redirect:/admin";


    }

    @RequestMapping("getUser")
    @ResponseBody
    public User getUser(HttpServletRequest request,Integer id){
        return userService.getInfo(id);
    }

    @RequestMapping("deleteUser")
    public String deleteUser(HttpServletRequest request,Integer id){
        userService.deleteUserById(id);
        return "redirect:/admin";
    }

}
