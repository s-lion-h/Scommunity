package com.slionh.community.service;

import com.slionh.community.entity.User;

/*
 * Create by s lion h on 2019/3/6
 */
public interface UserService {
    User login(String email,String password);
    User register(User user);
    Integer addPresident(User user);
    User getInfo(Integer id);
    Integer changeHead(User user);
}
