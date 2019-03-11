package com.slionh.community.service.serviceImpl;

import com.slionh.community.entity.Community;
import com.slionh.community.entity.Member;
import com.slionh.community.entity.MemberExample;
import com.slionh.community.entity.User;
import com.slionh.community.mapper.CommunityMapper;
import com.slionh.community.mapper.MemberMapper;
import com.slionh.community.mapper.UserMapper;
import com.slionh.community.service.MemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/*
 * Create by s lion h on 2019/3/7
 * status=1申请
 * status=2拒绝
 * status=3通过
 */
@Service
public class MemberServiceImpl implements MemberService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private MemberMapper memberMapper;
    @Resource
    private CommunityMapper communityMapper;

    @Override
    public List<Community> listUserJoined(Integer uid) {
        MemberExample memberExample=new MemberExample();
        System.out.println("uid:"+uid);
        memberExample.createCriteria().andUseridEqualTo(uid).andStatusEqualTo(3);
        List<Member> list = memberMapper.selectByExample(memberExample);
        List<Community> communities=new ArrayList<Community>();
        for (Member member:list){
            communities.add(communityMapper.selectByPrimaryKey(member.getCommunityid()));
        }
        return communities;
    }

    @Override
    public List<Community> listUserApply(Integer uid) {
        MemberExample memberExample=new MemberExample();
        memberExample.createCriteria().andUseridEqualTo(uid).andStatusEqualTo(1);
        List<Member> list = memberMapper.selectByExample(memberExample);
        List<Community> communities=new ArrayList<Community>();
        for (Member member:list){
            communities.add(communityMapper.selectByPrimaryKey(member.getCommunityid()));
        }
        return communities;
    }

    @Override
    public List<User> listCommunityApply(Integer communityId) {
        MemberExample memberExample=new MemberExample();
        memberExample.createCriteria().andCommunityidEqualTo(communityId).andStatusEqualTo(1);
        List<Member> list = memberMapper.selectByExample(memberExample);

        List<User> users=new ArrayList<User>();
        for (Member member:list){
            users.add(userMapper.selectByPrimaryKey(member.getUserid()));
        }
        return users;
    }

    @Override
    public List<User> listCommunityMember(Integer communityId) {
        MemberExample memberExample=new MemberExample();
        memberExample.createCriteria().andCommunityidEqualTo(communityId).andStatusEqualTo(3);
        List<Member> list = memberMapper.selectByExample(memberExample);

        List<User> users=new ArrayList<User>();
        for (Member member:list){
            users.add(userMapper.selectByPrimaryKey(member.getUserid()));
        }
        return users;
    }

    @Override
    public Integer getUserCommunityStatus(Integer uid, Integer communityId) {
        MemberExample memberExample=new MemberExample();
        memberExample.createCriteria().andUseridEqualTo(uid).andCommunityidEqualTo(communityId);
        List<Member> list=memberMapper.selectByExample(memberExample);
        if (list.size()>0){
            return list.get(0).getStatus();
        }
        return 0;
    }

    @Override
    public Integer addUserApply(Integer uid, Integer communityId,String description) {
        Member member=new Member();
        member.setCommunityid(communityId);
        member.setUserid(uid);
        member.setStatus(1);
        member.setDescription(description);
        return memberMapper.insert(member);
    }

    @Override
    public Integer accessApply(Integer uid, Integer communityId) {
        MemberExample memberExample=new MemberExample();
        memberExample.createCriteria().andCommunityidEqualTo(communityId).andUseridEqualTo(uid);
        Member old=memberMapper.selectByExample(memberExample).get(0);
        Member member=new Member();
        member.setIdmember(old.getIdmember());
        member.setCommunityid(communityId);
        member.setUserid(uid);
        member.setStatus(3);
        return memberMapper.updateByPrimaryKeySelective(member);
    }

    @Override
    public Integer deleteMember(Integer communityId, Integer memberId) {
        MemberExample memberExample=new MemberExample();
        memberExample.createCriteria().andCommunityidEqualTo(communityId).andUseridEqualTo(memberId);
        return memberMapper.deleteByExample(memberExample);
    }
}
