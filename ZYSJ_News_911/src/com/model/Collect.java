package com.model;

public class Collect {
	//private int collectId;
	private News news;
	private User user;
	
	public Collect() {}

//	public int getCollectId() {
//		return collectId;
//	}
//
//	public void setCollectId(int collectId) {
//		this.collectId = collectId;
//	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Collect [news=" + news + ", user=" + user + "]";
	}

	
}
