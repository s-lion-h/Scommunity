package com.slionh.community.service;

import com.slionh.community.entity.News;

import java.util.List;

/*
 * Create by s lion h on 2019/3/7
 */
public interface NewsService {
    Integer addNews(News news);
    List<News> listNews();
    News getNews(Integer id);
    Integer updateNews(News news);
    Integer deleteNews(Integer id);
}
