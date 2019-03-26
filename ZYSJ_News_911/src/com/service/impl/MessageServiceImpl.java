package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.MessageMapper;
import com.model.Message;
import com.service.MessageService;
@Service
@Transactional
public class MessageServiceImpl implements MessageService {

	@Override
	public List<Message> findAllMessage() {
		List<Message> messages = messageMapper.findAllMessage();
		return messages;
	}

	@Override
	public void addMessage(String name) {
		messageMapper.addMessage(name);
		
	}

	@Override
	public void delMessage(int id) {
		messageMapper.delMessage(id);
		
	}

	@Override
	public void updateUser(int id, String name) {
		
	}
	
	@Autowired
	public MessageMapper messageMapper;

}
