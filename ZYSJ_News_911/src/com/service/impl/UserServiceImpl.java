package com.service.impl;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.UserMapper;
import com.model.Subscribe;
import com.model.User;

import com.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	public UserMapper userMapper;

	@Override
	public User testLogin1(User user) {
		User u = userMapper.testLogin1(user);
		return u;
	}

	@Override
	public User testLogin(User user) {
		User u = userMapper.testLogin(user);

		return u;
	}

	@Override
	public void addUser(User user) {
		userMapper.addUser(user);

	}

	@Override
	public void addNews(String newsTitle, String newsContent, String newsImg, int newsLike, int userId, int newsStatus,
			int typeId, Date publishTime) {
		Map<String, Object> map = new HashMap<>();
		map.put("newsTitle", newsTitle);
		map.put("newsContent", newsContent);
		map.put("newsImg", newsImg);
		map.put("newsLike", newsLike);
		map.put("userId", userId);
		map.put("newsStatus", newsStatus);
		map.put("typeId", typeId);
		map.put("publishTime", publishTime);
		userMapper.addNews(map);

	}

	@Override
	public List<User> findUserType() {
		List<User> users = userMapper.findUserType();
		return users;
	}
	
	@Override
	public List<User> findUserTypeByUserId(int userId) {
		List<User> users = userMapper.findUserTypeByUserId(userId);
		return users;
	}
	
	@Override
	public void addUserType(Subscribe subscribe) {
		userMapper.addUserType(subscribe);
	}
	
	
}
