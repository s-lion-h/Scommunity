package com.slionh.community.service;

import com.slionh.community.entity.Newscomment;
import com.slionh.community.entity.User;

import java.util.List;

/*
 * Create by s lion h on 2019/3/8
 */
public interface NewsCommentService {
    List<Newscomment> listNewsCommentByNewsId(Integer newsId);
    List<User> listNewsCommentUsersByNewsId(Integer newsId);
}
