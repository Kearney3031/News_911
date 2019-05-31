package com.model;

import java.sql.Date;

public class News {
	
public News( String newsTitle, String newsContent, String newsImg, int newsLike, int userId,
			int newsStatus, int typeId, Date publishTime) {
		this.newsTitle = newsTitle;
		this.newsContent = newsContent;
		this.newsImg = newsImg;
		this.newsLike = newsLike;
		this.userId = userId;
		this.newsStatus = newsStatus;
		this.typeId = typeId;
		this.publishTime = publishTime;
	}
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
	public int getNewsStatus() {
		return newsStatus;
	}
	public void setNewsStatus(int newsStatus) {
		this.newsStatus = newsStatus;
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
private int newsLike;
private int userId;
private int newsStatus;
private int typeId;
private Date publishTime;

}
