package com.mapper;

import java.util.List;
import java.util.Map;

import com.model.Collect;
import com.model.News;
import com.model.Subscribe;
import com.model.User;
import com.model.Video;

public interface VideoMapper {
	void addVideo(Video v);//添加视频 
	List<Video> All(int id);
	List<Video> findAllVideo();
	Video findVideoById(int id);
	void addLike(int id);//点赞数
	void addDTimes(int id);//下载次数
}
