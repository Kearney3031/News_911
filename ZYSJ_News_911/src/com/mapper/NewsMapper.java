package com.mapper;

import java.util.List;
import java.util.Map;

import com.model.News;

public interface NewsMapper {
	 void addNews(News news);//新闻提交
	
	 void addLike(int id);//点赞
	 List<News> findByPage(Map<String, Integer> map);//返回一页新闻

	 //这是管理员用的findAll
	 List<News> findAll();
	 int getCount();//返回一共有多少个新闻
	 //新闻审核通过
	void passNews(int id);

	 
	List<News> findHotNews();
	List<News> findPointNews();
	 News findNewsByNewsId(int id);

}
