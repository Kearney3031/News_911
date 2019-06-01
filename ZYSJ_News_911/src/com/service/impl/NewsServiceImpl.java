package com.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.NewsMapper;
import com.model.News;
import com.service.NewsService;

@Service
@Transactional
public class NewsServiceImpl  implements NewsService{
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
	
}
