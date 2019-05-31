package com.model;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.text.SimpleDateFormat;

public class Message {
	private int messageId;
	private String megContent;
	private int megLike;
	private Date time;
	private int userId;
	private int newsId;
	private int videoId;
	private int topicId;
	
	private User user;

	public Message() {
	}


	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getMegContent() {
		return megContent;
	}

	public void setMegContent(String megContent) {
		this.megContent = megContent;
	}

	public int getMegLike() {
		return megLike;
	}

	public void setMegLike(int megLike) {
		this.megLike = megLike;
	}

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")  
	public Date getTime() {
		return time;
	}

	public void setTime(String time) {
//		System.out.println(time);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			//System.out.println(sdf.parse(time));
			this.time = sdf.parse(time);
		} catch (Exception e) {
			System.out.println("ERROR");
		}
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getNewsId() {
		return newsId;
	}

	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", megContent=" + megContent + ", megLike=" + megLike + ", time="
				+ time + ", userId=" + userId + ", newsId=" + newsId + ", videoId=" + videoId + ", topicId=" + topicId
				+ ", user=" + user + "]";
	}


	



}
