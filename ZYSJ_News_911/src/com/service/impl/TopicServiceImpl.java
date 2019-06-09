package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.TopicMapper;
import com.mapper.TypeMapper;
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
	
	
	
}
