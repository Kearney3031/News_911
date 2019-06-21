package com.mapper;

import java.util.List;
import java.util.Map;

import com.model.Collect;
import com.model.Feedback;
import com.model.News;
import com.model.Subscribe;
import com.model.User;

public interface UserMapper {

	void addUser(User user);

	User testLogin(User user);// 用户名登录

	User testLogin1(User user);// 邮箱登录

	void addFeedback(Feedback fb);
	
	User findUserById(int userId);

	List<User> findUserType();

	List<User> findUserTypeByUserId(int userId);

	void addUserType(Subscribe subscribe);
	
	List<User> findUserNewsByUserId(int userId);
	
	void addUserCollectNews(Collect collect);

	void deleteUserCollectNews(Collect collect);
	void addUserScore(int id);
}
