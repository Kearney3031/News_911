package com.model;

import java.util.List;

public class User {
	private String userName;
	private String password;
	private String userRealName;
	private String phone;
	private String email;
	private int userType;
	private int userId;
	private int score;

	// 用于存放用户所订阅的type(与User多对多）
	private List<Type> types;
	
	//用于存放用户收藏的News（与User多对多）
	private List<News> newsList;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {

		this.userRealName = userRealName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<Type> getTypes() {
		return types;
	}

	public void setTypes(List<Type> types) {
		this.types = types;
	}
	
	
	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", userRealName=" + userRealName + ", phone="
				+ phone + ", email=" + email + ", userType=" + userType + ", userId=" + userId + ", score=" + score
				+ ", types=" + types + ", newsList=" + newsList + "]";
	}

	

}
