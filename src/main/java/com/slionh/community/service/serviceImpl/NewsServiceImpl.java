package com.slionh.community.service.serviceImpl;

import com.slionh.community.entity.News;
import com.slionh.community.entity.NewsExample;
import com.slionh.community.mapper.NewsMapper;
import com.slionh.community.service.NewsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/*
 * Create by s lion h on 2019/3/7
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Resource
    private NewsMapper newsMapper;
    @Override
    public Integer addNews(News news) {
        return newsMapper.insert(news);
    }

    @Override
    public List<News> listNews() {
        return newsMapper.selectByExample(new NewsExample());
    }

    @Override
    public News getNews(Integer id) {
//        NewsExample newsExample=new NewsExample();
        return newsMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer updateNews(News news) {
        return newsMapper.updateByPrimaryKeySelective(news);
    }

    @Override
    public Integer deleteNews(Integer id) {
        return newsMapper.deleteByPrimaryKey(id);
    }
}
