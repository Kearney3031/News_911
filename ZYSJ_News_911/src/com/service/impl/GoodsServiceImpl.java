package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.GoodsMapper;
import com.model.Goods;
import com.service.GoodsService;
@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;
	

	@Override
	public List<Goods> findAllGoods() {
		List<Goods> goodsList = goodsMapper.findAllGoods();
		return goodsList;
	}

	
	@Override
	public void addGoods(Goods goods) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delGoods(int id) {
		// TODO Auto-generated method stub

	}

}
