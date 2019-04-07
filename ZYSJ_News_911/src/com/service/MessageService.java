package com.service;

import java.util.List;

import com.model.Message;



public interface MessageService {
	List<Message> findAllMessage();
	 void addMessage(Message mesage);
	 void delMessage(int id);
	 void updateUser(int id,String name);
}
