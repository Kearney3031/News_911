package com.service;

import java.util.List;

import com.model.Topic;
import com.model.Type;
import com.model.Video;

public interface VideoService {
	void addVideo(Video v);
	List<Video> findAllVideo();
	Video findVideoById(int id);
	
	
}
