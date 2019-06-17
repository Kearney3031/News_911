package com.model;

public class Advert {

	private int advertId;
	private String advertName;
	private String advertImg;
	private String advertLink;
	
	public Advert(){}
	
	public int getAdvertId() {
		return advertId;
	}
	public void setAdvertId(int advertId) {
		this.advertId = advertId;
	}
	public String getAdvertName() {
		return advertName;
	}
	public void setAdvertName(String advertName) {
		this.advertName = advertName;
	}
	public String getAdvertImg() {
		return advertImg;
	}
	public void setAdvertImg(String advertImg) {
		this.advertImg = advertImg;
	}
	public String getAdvertLink() {
		return advertLink;
	}
	public void setAdvertLink(String advertLink) {
		this.advertLink = advertLink;
	}

	@Override
	public String toString() {
		return "Advert [advertId=" + advertId + ", advertName=" + advertName + ", advertImg=" + advertImg
				+ ", advertLink=" + advertLink + "]";
	}
	
	
	
	
}
