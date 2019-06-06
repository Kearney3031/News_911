package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.NewsMapper;
import com.model.News;
import com.service.NewsService;

@Service
@Transactional
public class NewsServiceImpl  implements NewsService{
	@Autowired
	NewsMapper newsmapper;
	@Override
	public void addNews(News news) {
		newsmapper.addNews(news);
		
	}

	@Override
	public void publish(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addLike(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<News> findAllNews() {
		
		return newsmapper.findAllNews();
	}
	
}
