package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.TopicMapper;
import com.mapper.TypeMapper;
import com.model.PageBean;
import com.model.Topic;
import com.model.Type;
import com.service.TopicService;
import com.service.TypeService;
@Service
@Transactional
public class TopicServiceImpl implements TopicService {
	

	@Override
	public void addTopic(Topic t) {
		topicMapper.addTopic(t);
		
	}

	@Autowired
	public TopicMapper topicMapper;

	@Override
	public List<Topic> findAllTopic() {
		return topicMapper.findAllTopic();
	}

	@Override
	public Topic findTopicById(int id) {
		return  topicMapper.findTopicById(id);
	}

	@Override
	public void deleteTop(int topicId) {
		topicMapper.delTopic(topicId);
	}

	@Override
	public PageBean selTopicByPage(int pageNumber, int pageSize) {
		PageBean pb=new PageBean();
		pb.setPageNumber(pageNumber);
		pb.setPageSize(pageSize);
		
		long count=topicMapper.count();
		pb.setTotalPage(count%pageSize==0? count/pageSize:(count/pageSize)+1);
		
		List<Topic> topiclist=topicMapper.findAllTopicByPage((pageNumber-1)*pageSize, pageSize);
		pb.setList(topiclist);
		return pb;
	}
	
	
	
}
