package com.slionh.community.service;

import com.slionh.community.entity.Community;

import java.util.List;

/*
 * Create by s lion h on 2019/3/7
 */
public interface CommunityService {
    Integer addCommunity(Community community);
    List<Community> listCommunity();
    List<Community> listCommunity(Integer num);
    Community getCommunity(Integer id);
    Integer updateCommunity(Community community);
    Integer deleteCommunity(Integer id);
    Community getCommunityByPresidentId(Integer id);
    Integer updateCommunitySelective(Integer id ,String introduction,String logo);
}
