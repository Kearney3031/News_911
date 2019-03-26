package com.model;

public class Message {
	private int messageId;
	private String megContent;
	private int megLike;
	private int userId;
	private int newsId;
	private int videoId;
	private int topicId;
	
	
	public Message() {}
	
	
	
	public Message(int messageId, String megContent, int megLike, int userId, int newsId, int videoId, int topicId) {
		super();
		this.messageId = messageId;
		this.megContent = megContent;
		this.megLike = megLike;
		this.userId = userId;
		this.newsId = newsId;
		this.videoId = videoId;
		this.topicId = topicId;
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
	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", megContent=" + megContent + ", megLike=" + megLike + ", userId="
				+ userId + ", newsId=" + newsId + ", videoId=" + videoId + ", topicId=" + topicId + "]";
	}
	
}
