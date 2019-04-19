package com.mapper;

import java.util.List;
import java.util.Map;

import com.model.User;



public interface UserMapper {

void addUser1(User user);
User testLogin(User user);//用户名登录
User testLogin1(User user);//邮箱登录
void addNews(Map<String,Object> map);
}
