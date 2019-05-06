package com.model;

public class Subscribe {
	private int subscribeId;
	private User user;
	private Type type;
	
	
	public Subscribe(){}


	public int getSubscribeId() {
		return subscribeId;
	}


	public void setSubscribeId(int subscribeId) {
		this.subscribeId = subscribeId;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}


	@Override
	public String toString() {
		System.out.println("SubscribeToString");
		return "Subscribe [subscribeId=" + subscribeId + ", user=" + user + ", type=" + type + "]";
	}

	
	
	
}
