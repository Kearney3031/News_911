package com.model;

public class Video {
public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
public int getdTimes() {
		return dTimes;
	}
	public void setdTimes(int dTimes) {
		this.dTimes = dTimes;
	}
public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public String getVideoPath() {
		return videoPath;
	}
	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}
	public int getVideoLike() {
		return videoLike;
	}
	public void setVideoLike(int videoLike) {
		this.videoLike = videoLike;
	}
	public String getVideoRealName() {
		return videoRealName;
	}
	public void setVideoRealName(String videoRealName) {
		this.videoRealName = videoRealName;
	}
	
	
private int videoId;
private int dTimes;
private String videoName;
private String videoPath;
private int videoLike;
private  String videoRealName;
private int userId;
public Video() {}

}
