package com.slionh.community.service.serviceImpl;

import com.slionh.community.entity.Newscomment;
import com.slionh.community.entity.NewscommentExample;
import com.slionh.community.entity.User;
import com.slionh.community.mapper.NewscommentMapper;
import com.slionh.community.mapper.UserMapper;
import com.slionh.community.service.NewsCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/*
 * Create by s lion h on 2019/3/8
 */
@Service
public class NewsCommentServiceImpl implements NewsCommentService {
    @Resource
    private NewscommentMapper newscommentMapper;
    @Resource
    private UserMapper userMapper;
    @Override
    public List<Newscomment> listNewsCommentByNewsId(Integer newsId) {
        NewscommentExample newscommentExample=new NewscommentExample();
        newscommentExample.createCriteria().andNewsidEqualTo(newsId);

        return newscommentMapper.selectByExample(newscommentExample);
    }

    @Override
    public List<User> listNewsCommentUsersByNewsId(Integer newsId) {
        NewscommentExample newscommentExample=new NewscommentExample();
        newscommentExample.createCriteria().andNewsidEqualTo(newsId);
        List<User> userList=new ArrayList<User>();
        List<Integer> temp=new ArrayList<Integer>();
        for (Newscomment newscomment:newscommentMapper.selectByExample(newscommentExample)){
            if (!temp.contains(newscomment.getUserid())){
                temp.add(newscomment.getUserid());
                userList.add(userMapper.selectByPrimaryKey(newscomment.getUserid()));
            }
        }
        return userList;
    }
}
