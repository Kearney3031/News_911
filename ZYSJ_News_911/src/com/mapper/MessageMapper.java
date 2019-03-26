package com.mapper;

import java.util.List;
import java.util.Map;

import com.model.Message;

public interface MessageMapper {
	List<Message> findAllMessage();
	void addMessage(String name);
	void delMessage(int id);
	void updateMessage(Map<String,Object> map);
}
