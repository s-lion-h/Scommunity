package com.slionh.community.service.serviceImpl;

import com.slionh.community.entity.Community;
import com.slionh.community.entity.CommunityExample;
import com.slionh.community.entity.UserExample;
import com.slionh.community.mapper.CommunityMapper;
import com.slionh.community.mapper.UserMapper;
import com.slionh.community.service.CommunityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/*
 * Create by s lion h on 2019/3/7
 */
@Service
public class CommunityServiceImpl implements CommunityService {
    @Resource
    private CommunityMapper communityMapper;
    @Resource
    private UserMapper userMapper;

    @Override
    public Integer addCommunity(Community community) {
        return communityMapper.insert(community);
    }

    @Override
    public List<Community> listCommunity() {
        List<Community> list=new ArrayList<Community>();
        for(Community community: communityMapper.selectByExample(new CommunityExample())){
            community.setOther(userMapper.selectByPrimaryKey(community.getPresident()).getRealname());
            list.add(community);

        }
        return list;
    }

    @Override
    public List<Community> listCommunity(Integer num) {
        return communityMapper.selectByExample(new CommunityExample()).subList(0,4);
    }

    @Override
    public Community getCommunity(Integer id) {
        return communityMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer updateCommunity(Community community) {
        return communityMapper.updateByPrimaryKeySelective(community);
    }

    @Override
    public Integer deleteCommunity(Integer id) {
        return communityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Community getCommunityByPresidentId(Integer id) {
        CommunityExample communityExample=new CommunityExample();
        communityExample.createCriteria().andPresidentEqualTo(id);
        List<Community> list = communityMapper.selectByExample(communityExample);
        if (list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public Integer updateCommunitySelective(Integer id,String introduction, String logo) {
        Community community=new Community();
        community.setIdcommunity(id);
        community.setLogo(logo);
        community.setIntroduction(introduction);

        return communityMapper.updateByPrimaryKeySelective(community);
    }
}
