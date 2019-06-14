package com.service;

import java.util.List;

import com.model.Goods;

public interface GoodsService {
	List<Goods> findAllGoods();
	void addGoods(Goods goods);
	void delGoods(int id);
	
}
