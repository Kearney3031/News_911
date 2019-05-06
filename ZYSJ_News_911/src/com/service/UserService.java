package com.service;

import java.sql.Date;
import java.util.List;

import com.model.User;


public interface UserService {
 
 void addNews(String newsTitle,String newsContent,String newsImg,int newsLike,int userId,int newsStatus,int typeId,Date publishTime);
 void addUser(User user);
 User testLogin(User user);
 User testLogin1(User user);
 
 
 List<User> findUserType();
 
 List<User> findUserTypeByUserId(int userId);
}	
