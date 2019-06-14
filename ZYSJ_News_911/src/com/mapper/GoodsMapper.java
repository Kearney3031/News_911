package com.mapper;

import java.util.List;

import com.model.Goods;

public interface GoodsMapper {
	List<Goods> findAllGoods();
	void addGoods(Goods goods);
	void delGoods(int id);
}
