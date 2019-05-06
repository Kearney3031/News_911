package com.model;

import java.util.List;

public class Type {
	private int typeId;
	private String typeName;
	private String typeIntroduce;
	
	//用于存放订阅了的用户（与User多对多）
	private List<User> users;
	
	public Type() {}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeIntroduce() {
		return typeIntroduce;
	}

	public void setTypeIntroduce(String typeIntroduce) {
		this.typeIntroduce = typeIntroduce;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Type [typeId=" + typeId + ", typeName=" + typeName + ", typeIntroduce=" + typeIntroduce + ", users="
				+ users + "]";
	}
	
}
