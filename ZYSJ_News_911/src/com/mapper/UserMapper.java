package com.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.model.Collect;
import com.model.Feedback;
import com.model.Subscribe;
import com.model.User;

public interface UserMapper {

	void addUser(User user);
	void buy(Map<String,Integer> map);

	User testLogin(User user);// 用户名登录

	User testLogin1(User user);// 邮箱登录
	
	//删除用户
	@Delete("delete from user where userId=#{param1}")
	void deleteUser(Integer userId);
		
	//分页查询所有user
	@Select("select * from user limit #{param1},#{param2}")
	List<User> findAllUserByPage(int pageStart,int pageSize);
			
	//总记录数
    @Select("select count(*) from user")
	long count();

	void addFeedback(Feedback fb);
	
	User findUserById(int userId);

	List<User> findUserType();

	List<User> findUserTypeByUserId(int userId);

	void addUserType(Subscribe subscribe);
	
	void deleteUserType(int userId);
	
	List<User> findUserNewsByUserId(int userId);
	
	void addUserCollectNews(Collect collect);

	void deleteUserCollectNews(Collect collect);
	void addUserScore(int id);
	void updateRealName(Map<String, Object> map);
	void updatePhone(Map<String, Object> map);
}
