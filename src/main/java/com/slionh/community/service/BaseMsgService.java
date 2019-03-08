package com.slionh.community.service;

import com.slionh.community.entity.Webdescription;

/*
 * Create by s lion h on 2019/3/7
 */
public interface BaseMsgService {
    Webdescription getWebDescription();
    Integer updateWebDescription(Webdescription webdescription);
}
