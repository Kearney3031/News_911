package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.NoticeMapper;
import com.mapper.TopicMapper;
import com.mapper.TypeMapper;
import com.model.Notice;
import com.model.Topic;
import com.model.Type;
import com.service.NoticeService;
import com.service.TopicService;
import com.service.TypeService;
@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {
	

	

	@Autowired
	public NoticeMapper noticeMapper;

	@Override
	public void update(String content) {
		noticeMapper.update(content);
		
	}

	@Override
	public List<Notice> find() {
		return noticeMapper.find();
	}

	
	
	
	
}
