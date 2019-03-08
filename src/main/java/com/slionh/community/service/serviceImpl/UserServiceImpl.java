package com.slionh.community.service.serviceImpl;

import com.slionh.community.entity.User;
import com.slionh.community.entity.UserExample;
import com.slionh.community.mapper.UserMapper;
import com.slionh.community.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/*
 * Create by s lion h on 2019/3/6
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User login(String email, String password) {
        UserExample userExample=new UserExample();
        userExample.createCriteria().andEmailEqualTo(email).andPasswordEqualTo(password);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList.size()==0){
//            登陆失败
            System.out.println("登陆失败：用户名或密码错误");
            return null;
        }else if (userList.size()>0){
            System.out.println("login success : "+userList.get(0).toString());
            return userList.get(0);
        }else{
            System.out.println("登陆失败：未知错误");
            return null;
        }

    }

    @Override
    public User register(User user) {
        userMapper.insert(user);
        return userMapper.selectByPrimaryKey(user.getIduser());
    }

    @Override
    public Integer addPresident(User user) {
        user.setLevel(2);
        userMapper.insert(user);
        return user.getIduser();
    }

    @Override
    public User getInfo(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer changeHead(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
