package com.slionh.community.service.serviceImpl;

import com.slionh.community.entity.Border;
import com.slionh.community.entity.BorderExample;
import com.slionh.community.mapper.BorderMapper;
import com.slionh.community.service.BorderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/*
 * Create by s lion h on 2019/3/9
 */
@Service
public class BorderServiceImpl implements BorderService {
    @Resource
    private BorderMapper borderMapper;

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

        return null;
    }
}
