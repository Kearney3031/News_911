package com.service;

import java.util.List;

import com.model.Notice;
import com.model.Topic;
import com.model.Type;

public interface NoticeService {
	void update(String content);
	List<Notice> find();
}
