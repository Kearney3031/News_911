package com.mapper;

import java.util.List;
import com.model.Advert;


public interface AdvertMapper {

	List<Advert> findAllAdvert();
	List<Advert> findAdvert();
	void addAdvert(Advert advert);
	void delAdvert(int id);
	
}
