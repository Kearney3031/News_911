package com.service;

import java.util.List;

import com.model.News;

public interface NewsService {
	 void addNews(News news);//新闻提交
	 void publish(int id);//审核通过
	 void addLike(int id);//点赞
	 List<News> findByPage(int page,int pageSize);//返回所有新闻
	 int findTotalPage(int pageSize);
	 News display(int id);
}
