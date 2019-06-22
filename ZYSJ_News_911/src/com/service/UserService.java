package com.service;

import java.sql.Date;
import java.util.List;

import com.model.Collect;
import com.model.Feedback;
import com.model.News;
import com.model.Subscribe;
import com.model.User;

public interface UserService {

	void addUser(User user);

	User testLogin(User user);

	User testLogin1(User user);
	
	User findUserById(int userId);

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
