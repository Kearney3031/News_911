package com.mapper;

import java.util.List;

import com.model.News;

public interface NewsMapper {
	public void addNews(News news);//新闻提交
	public void publish(int id);//审核通过
	public void addLike(int id);//点赞
	public List<News> findAllNews();//返回所有新闻
}
