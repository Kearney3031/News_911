package com.service;

import java.util.List;

import com.model.News;

public interface NewsService {
	List<News> findHotNews();//热点新闻
	List<News> findPointNews();//要点新闻
	 void addNews(News news);//新闻提交
	
	 void addLike(int id);//点赞
	 List<News> findByPage(int page,int pageSize);//返回所有新闻
	 int findTotalPage(int pageSize);
	//这是管理员用的findAll
	List<News> findAll();
	 
	 //新闻审核通过
	 void passNews(int id);
	 News findNewsByNewsId(int id);
	 
	 //分类浏览
	 List<News> showNewsByTypeId(int typeId);
	 
	 //关键字查询
	 News showNewsByKeyValue(String keyValue);

}
