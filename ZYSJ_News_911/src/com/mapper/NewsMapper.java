package com.mapper;

import com.model.News;

public interface NewsMapper {
	public void addNews(News news);//新闻提交
	public void publish(int id);//审核通过
	public void addLike(int id);//点赞
}
