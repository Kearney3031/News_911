package com.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.model.Collect;
import com.model.Feedback;
import com.model.News;
import com.model.Subscribe;
import com.model.User;

public interface UserService {
	void updateRealName(int id,String userRealName);
	void updatePhone(int id ,String phone);
	void addUser(User user);
	void buy(int id,int price);
	User testLogin(User user);

	User testLogin1(User user);
	
	User findUserById(int userId);

	List<User> findUserType();
	void addFeedback(Feedback fb);
	List<User> findUserTypeByUserId(int userId);

	void addUserType(Subscribe subscribe);
	
	List<User> findUserNewsByUserId(int userId);
	
	void addUserCollectNews(Collect collect);
	
	void deleteUserCollectNews(Collect collect);
	void addUserScore(int id);
}
