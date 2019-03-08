package com.slionh.community.service;

import com.slionh.community.entity.Border;

import java.util.List;

/*
 * Create by s lion h on 2019/3/9
 */
public interface BorderService {
    Integer addBorder(Border border);
    Integer deleteBorder(Integer borderId);
    List<Border> listBorder();
    List<Border> listBorder(Integer page);

}
