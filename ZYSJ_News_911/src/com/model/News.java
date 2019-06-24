package com.model;


import java.sql.Date;
import java.util.List;


public class News {
	public int getNewsStatus() {
		return newsStatus;
	}

	public void setNewsStatus(int newsStatus) {
		this.newsStatus = newsStatus;
	}

	public int getNewsLike() {
		return newsLike;
	}

	public void setNewsLike(int newsLike) {
		this.newsLike = newsLike;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}



	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	private int newsId;
	private String newsTitle;
	private String newsContent;
	private String newsImg;
	
	//用于存放订阅了的用户（与User多对多）
	private List<User> users;
	private int newsLike;
	private int userId;
	private int newsStatus;
	private int typeId;
	private Date publishTime;
	
	
	public News() {}
	
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getNewsContent() {
		return newsContent;
	}
	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
	public String getNewsImg() {
		return newsImg;
	}
	public void setNewsImg(String newsImg) {
		this.newsImg = newsImg;
	}
	
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	@Override
	public String toString() {
		return "News [newsId=" + newsId + ", newsTitle=" + newsTitle + ", newsContent=" + newsContent + ", newsImg="
				+ newsImg + ", users=" + users + "]";
	}

	

	
	

}
