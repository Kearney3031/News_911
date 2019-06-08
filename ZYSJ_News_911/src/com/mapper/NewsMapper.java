package com.mapper;

import java.util.List;
import java.util.Map;

import com.model.News;

public interface NewsMapper {
	 void addNews(News news);//新闻提交
	 void publish(int id);//审核通过
	 void addLike(int id);//点赞
	 List<News> findByPage(Map<String, Integer> map);//返回一页新闻
	 int getCount();//返回一共有多少个新闻
	 News display(int id);//根据ID返回新闻
}
