package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.UserMapper;
import com.model.Collect;
import com.model.Feedback;
import com.model.PageBean;
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
	public User findUserById(int userId) {
		User user = userMapper.findUserById(userId);
		return user;
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
	
	@Transactional
	@Override
	public void deleteUserType(int userId) {
		userMapper.deleteUserType(userId);
	}

	@Override
	public List<User> findUserNewsByUserId(int userId){
		List<User> users= userMapper.findUserNewsByUserId(userId);
		return users;
	}

	@Transactional
	@Override
	public void addUserCollectNews(Collect collect) {
		userMapper.addUserCollectNews(collect);
	}
	
	@Override
	public void deleteUserCollectNews(Collect collect) {
		userMapper.deleteUserCollectNews(collect);
	}

	@Override
	public void addUserScore(int id) {
		userMapper.addUserScore(id);
		
	}

	@Override
	public void addFeedback(Feedback fb) {
		userMapper.addFeedback(fb);
		
	}
	
	@Override
	public void delUser(Integer userId) {
		userMapper.deleteUser(userId);
		
	}

	@Override
	public PageBean selUserByPage(int pageNumber, int pageSize) {
		PageBean pb=new PageBean();
		pb.setPageNumber(pageNumber);
		pb.setPageSize(pageSize);
		
		long count=userMapper.count();
		pb.setTotalPage(count%pageSize==0? count/pageSize:(count/pageSize)+1);
		
		List<User> userlist=userMapper.findAllUserByPage((pageNumber-1)*pageSize, pageSize);
		pb.setList(userlist);
		return pb;
	}


}
