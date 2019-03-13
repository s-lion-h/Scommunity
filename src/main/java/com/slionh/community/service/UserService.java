package com.slionh.community.service;

import com.slionh.community.entity.User;

import java.util.List;

/*
 * Create by s lion h on 2019/3/6
 */
public interface UserService {
    User login(String email,String password);
    User register(User user);
    Integer addPresident(User user);
    User getInfo(Integer id);
    Integer changeHead(User user);
    User updateUserSelective(User user);
    List<User> listUser(Integer page);
    Integer deleteUserById(Integer id);
    Integer emailIsUsed(String email);
}
