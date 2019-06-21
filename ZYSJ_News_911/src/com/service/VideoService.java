package com.service;

import java.util.List;

import com.model.Topic;
import com.model.Type;
import com.model.Video;

public interface VideoService {
	void addVideo(Video v);
	List<Video> findAllVideo();
	Video findVideoById(int id);
	void addLike(int id);//点赞数
	void addDTimes(int id);//下载次数
	
}
