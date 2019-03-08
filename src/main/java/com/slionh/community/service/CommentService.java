package com.slionh.community.service;

import com.slionh.community.entity.Activitycomment;
import com.slionh.community.entity.Newscomment;

/*
 * Create by s lion h on 2019/3/8
 */
public interface CommentService {
    Integer addActivityComment(Activitycomment activitycomment);
    Integer addNewsComment(Newscomment newscomment);
}
