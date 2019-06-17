package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.AdvertMapper;
import com.mapper.GoodsMapper;
import com.model.Advert;
import com.model.Goods;
import com.service.AdvertService;
import com.service.GoodsService;

@Service
@Transactional
public class AdvertServiceImpl implements AdvertService {

	@Autowired
	private AdvertMapper advertMapper;
	

	@Override
	public List<Advert> findAllAdvert() {
		List<Advert> advertList = advertMapper.findAllAdvert();
		return advertList;
	}

	
	@Override
	public void addAdvert(Advert advert) {
		advertMapper.addAdvert(advert);

	}

	@Override
	public void delAdvert(int id) {
		advertMapper.delAdvert(id);

	}

}

