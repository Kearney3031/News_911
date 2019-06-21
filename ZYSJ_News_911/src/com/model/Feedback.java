package com.model;

import java.sql.Date;

public class Feedback {
	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
	public String getFeedbackName() {
		return feedbackName;
	}
	public void setFeedbackName(String feedbackName) {
		this.feedbackName = feedbackName;
	}
	public String getFeedbackContent() {
		return feedbackContent;
	}
	public void setFeedbackContent(String feedbackContent) {
		this.feedbackContent = feedbackContent;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getFbTime() {
		return fbTime;
	}
	public void setFbTime(Date fbTime) {
		this.fbTime = fbTime;
	}
	private  int feedbackId;
	private String feedbackName;
	private String feedbackContent;
	private int userId;
	private  Date fbTime;
	public Feedback() {}
	
}
