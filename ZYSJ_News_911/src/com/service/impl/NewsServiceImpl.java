package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.NewsMapper;
import com.mapper.UserMapper;
import com.model.News;
import com.service.NewsService;

@Service
@Transactional
public class NewsServiceImpl  implements NewsService{
	
	

	@Override
	public void passNews(int id) {
		newsmapper.passNews(id);
		
	}

	@Override
	public List<News> findAll() {
		return newsmapper.findAll();
	}

	@Override
	public int findTotalPage(int pageSize) {
		
		int rows= newsmapper.getCount();
		if(rows%pageSize==0) {
			return rows/pageSize;
		}
		else {
			return rows/pageSize+1;
		}
		
		
	}

	@Override
	public List<News> findByPage(int page, int pageSize) {
		Map<String,Integer> map=new HashMap();
		map.put("page", (page-1)*pageSize);
		map.put("pageSize", pageSize);
		
		return newsmapper.findByPage(map);
	}

	@Autowired
	NewsMapper newsmapper;
	@Override
	public void addNews(News news) {
		newsmapper.addNews(news);
		
	}

	

	@Override
	public void addLike(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public News findNewsByNewsId(int id) {
		News news = newsmapper.findNewsByNewsId(id);
		return news;
	}

	@Override
	public List<News> findHotNews() {
		
		return newsmapper.findHotNews();
	}

	@Override
	public List<News> findPointNews() {
		
		return newsmapper.findPointNews();
	}
	
	@Override
	public List<News> showNewsByTypeId(int typeId) {
		return newsmapper.findNewsByTypeId(typeId);
	}

	@Override
	public List<News> showNewsByKeyValue(String newsTitle) {
		return newsmapper.findNewsByKeyValue(newsTitle);
	}


	
}
