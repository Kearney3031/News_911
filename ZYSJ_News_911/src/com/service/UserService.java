package com.service;

import java.util.List;

import com.model.Collect;
import com.model.Feedback;
import com.model.PageBean;
import com.model.Subscribe;
import com.model.User;

public interface UserService {

	void addUser(User user);

	User testLogin(User user);

	User testLogin1(User user);
	
	User findUserById(int userId);
	
	//删除用户
	void delUser(Integer userId);
		
	//查询用户
	PageBean selUserByPage(int pageNumber,int pageSize);

	List<User> findUserType();
	void addFeedback(Feedback fb);
	List<User> findUserTypeByUserId(int userId);

	void addUserType(Subscribe subscribe);
	
	void deleteUserType(int userId);
	
	List<User> findUserNewsByUserId(int userId);
	
	void addUserCollectNews(Collect collect);
	
	void deleteUserCollectNews(Collect collect);
	void addUserScore(int id);
}
