package com.slionh.community.service.serviceImpl;

import com.slionh.community.entity.Webdescription;
import com.slionh.community.mapper.WebdescriptionMapper;
import com.slionh.community.service.BaseMsgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/*
 * Create by s lion h on 2019/3/7
 */
@Service
public class BaseMsgServiceImpl implements BaseMsgService {
    @Resource
    private WebdescriptionMapper mapper;

    @Override
    public Webdescription getWebDescription() {
        return mapper.selectByPrimaryKey(1);
    }

    @Override
    public Integer updateWebDescription(Webdescription webdescription) {
        return mapper.updateByPrimaryKey(webdescription);
    }
}
