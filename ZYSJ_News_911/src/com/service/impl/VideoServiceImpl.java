package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.TopicMapper;
import com.mapper.TypeMapper;
import com.mapper.VideoMapper;
import com.model.Topic;
import com.model.Type;
import com.model.Video;
import com.service.TopicService;
import com.service.TypeService;
import com.service.VideoService;
@Service
@Transactional
public class VideoServiceImpl implements VideoService {
	


	@Override
	public List<Video> findAllVideo() {
		return videoMapper.findAllVideo();
	}

	@Override
	public void addVideo(Video v) {
		videoMapper.addVideo(v);
		
	}

	@Autowired
	public VideoMapper videoMapper;

	@Override
	public Video findVideoById(int id) {
		return videoMapper.findVideoById(id);
	}

	@Override
	public void addLike(int id) {
		// TODO Auto-generated method stub
		videoMapper.addLike(id);
	}

	@Override
	public void addDTimes(int id) {
		// TODO Auto-generated method stub
		videoMapper.addDTimes(id);
	}

	@Override
	public List<Video> All(int id) {
		return videoMapper.All(id);
	}

	
	
	
	
}
