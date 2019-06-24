package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.FeedbackMapper;
import com.mapper.NoticeMapper;
import com.mapper.TopicMapper;
import com.mapper.TypeMapper;
import com.model.Feedback;
import com.model.Topic;
import com.model.Type;
import com.service.FeedbackService;
import com.service.NoticeService;
import com.service.TopicService;
import com.service.TypeService;
@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService {
	

	

	@Autowired
	public FeedbackMapper feedbackMapper;

	

	@Override
	public List<Feedback> findAll() {
		return feedbackMapper.findAll();
	}

	
	
	
	
}
