package com.mapper;

import java.util.List;
import java.util.Map;

import com.model.Message;

public interface MessageMapper {
	List<Message> findAllMessage();

	List<Message> findByUserId(int id);

	void addMessage(Message message);

	void delMessage(int id);

	void updateMessage(Map<String, Object> map);

	void addLike(int id);

	void subLike(int id);
	
	List<Message> findMessageByNewsId(int id);
	
	List<Message> findMessageByTopicId(int id);
	
	List<Message> findMessageByVideoId(int id);
	
	
}
