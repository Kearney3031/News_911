package com.model;

public class Subscribe {
	//private int subscribeId;
	private User user;
	private Type type;
	
	
	public Subscribe(){}


//	public int getSubscribeId() {
//		return subscribeId;
//	}
//
//
//	public void setSubscribeId(int subscribeId) {
//		this.subscribeId = subscribeId;
//	}


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
		return "Subscribe [user=" + user + ", type=" + type + "]";
	}



//	
//	private int subscribeId;
//	private int typeId;
//	private int userId;
//	public int getSubscribeId() {
//		return subscribeId;
//	}
//	public void setSubscribeId(int subscribeId) {
//		this.subscribeId = subscribeId;
//	}
//	public int getTypeId() {
//		return typeId;
//	}
//	public void setTypeId(int typeId) {
//		this.typeId = typeId;
//	}
//	public int getUserId() {
//		return userId;
//	}
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
//	@Override
//	public String toString() {
//		return "Subscribe [subscribeId=" + subscribeId + ", typeId=" + typeId + ", userId=" + userId + "]";
//	}
//	
//	
}
