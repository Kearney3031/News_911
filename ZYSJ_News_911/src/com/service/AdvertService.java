package com.service;

import java.util.List;

import com.model.Advert;


public interface AdvertService {
	List<Advert> findAllAdvert();
	void addAdvert(Advert advert);
	void delAdvert(int id);
	
}
