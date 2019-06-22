package com.service;

import java.util.List;

import com.model.PageBean;
import com.model.Topic;

public interface TopicService {
	void addTopic(Topic t);
	List<Topic> findAllTopic();
	Topic findTopicById(int id);
	
	//分页查询，把查询结果封装到一个PageBean中
	PageBean selTopicByPage(int pageNumber,int pageSize);
		
	//删除话题
	void deleteTop(int topicId);
	
}
