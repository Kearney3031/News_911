package com.service;

import java.util.List;

import com.model.Message;



public interface MessageService {
	List<Message> findAllMessage();
	List<Message> findByUserId(int id);
	 void addMessage(Message mesage);
	 void delMessage(int id);
	 void updateUser(int id,String name);
	 void addLike(int id);
	 void subLike(int id);
	List<Message> findMessageByNewsId(int id);
	List<Message> findMessageByTopicId(int id);
	List<Message> findMessageByVideoId(int id);
	 
}
