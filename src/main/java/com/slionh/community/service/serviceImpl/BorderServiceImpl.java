package com.slionh.community.service.serviceImpl;

import com.slionh.community.entity.*;
import com.slionh.community.mapper.BorderMapper;
import com.slionh.community.mapper.BordertopMapper;
import com.slionh.community.mapper.UserMapper;
import com.slionh.community.service.BorderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/*
 * Create by s lion h on 2019/3/9
 */
@Service
public class BorderServiceImpl implements BorderService {
    @Resource
    private BorderMapper borderMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private BordertopMapper bordertopMapper;

    @Override
    public Integer addBorder(Border border) {
        return borderMapper.insert(border);
    }

    @Override
    public Integer deleteBorder(Integer borderId) {
        return borderMapper.deleteByPrimaryKey(borderId);
    }

    @Override
    public List<Border> listBorder() {
        return borderMapper.selectByExample(new BorderExample());
    }

    @Override
    public List<Border> listBorder(Integer page) {
        BorderExample borderExample=new BorderExample();
        borderExample.setLimit(20);
        borderExample.setOffset((page-1)*20);

        return borderMapper.selectByExample(borderExample);
    }

    @Override
    public List<User> listBorderUser(Integer page) {
        BorderExample borderExample=new BorderExample();
        List<User> userList=new ArrayList<User>();
        List<Integer> users=new ArrayList<Integer>();
        borderExample.setLimit(20);
        borderExample.setOffset((page-1)*20);
        for (Border border:borderMapper.selectByExample(borderExample)){
            if (!users.contains(border.getUserid())){
                users.add(border.getUserid());
                userList.add(userMapper.selectByPrimaryKey(border.getUserid()));
            }
        }
        System.out.println(userList.toString());
        return userList;
    }

    @Override
    public List<User> listBorderUser() {
        BorderExample borderExample=new BorderExample();
        List<User> userList=new ArrayList<User>();
        List<Integer> users=new ArrayList<Integer>();
        for (Border border:borderMapper.selectByExample(borderExample)){
            if (!users.contains(border.getUserid())){
                users.add(border.getUserid());
                userList.add(userMapper.selectByPrimaryKey(border.getUserid()));
            }
        }
        System.out.println(userList.toString());
        return userList;
    }

    @Override
    public List<Border> listBorderTop() {
        List<Border> borders=new ArrayList<Border>();
        for (Bordertop bordertop:bordertopMapper.selectByExample(new BordertopExample())){
            borders.add(borderMapper.selectByPrimaryKey(bordertop.getBorderid()));
        }
        return borders;
    }

    @Override
    public List<User> listBorderTopUser() {
        List<User> userList=new ArrayList<User>();
        List<Integer> users=new ArrayList<Integer>();
        for (Border border:listBorderTop()){
            if (!users.contains(border.getUserid())){
                users.add(border.getUserid());
                userList.add(userMapper.selectByPrimaryKey(border.getUserid()));
            }
        }
        return userList;
    }

    @Override
    public Integer addBorderTop(Integer borderId) {
        Bordertop bordertop=new Bordertop();
        bordertop.setBorderid(borderId);
        return bordertopMapper.insert(bordertop);
    }

    @Override
    public Integer deleteBordertop(Integer borderId) {
        BordertopExample bordertopExample=new BordertopExample();
        bordertopExample.createCriteria().andBorderidEqualTo(borderId);
        return bordertopMapper.deleteByExample(bordertopExample);
    }
}
