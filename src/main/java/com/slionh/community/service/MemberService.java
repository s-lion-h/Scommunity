package com.slionh.community.service;

import com.slionh.community.entity.Community;
import com.slionh.community.entity.Member;
import com.slionh.community.entity.User;

import java.util.List;

/*
 * Create by s lion h on 2019/3/7
 */
public interface MemberService {
    List<Community> listUserJoined(Integer uid);
    List<Community> listUserApply(Integer uid);
    List<User> listCommunityApply(Integer communityId);
    List<User> listCommunityMember(Integer communityId);
    Integer getUserCommunityStatus(Integer uid,Integer communityId);
    Integer addUserApply(Integer uid,Integer communityId,String description);
    Integer accessApply(Integer uid,Integer communityId);
}
