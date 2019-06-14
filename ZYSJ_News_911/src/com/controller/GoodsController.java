package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Goods;
import com.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	
	
	
	@RequestMapping(value = "/findAll")
	//@ResponseBody
	public List<Goods> findAllGoods() {
		List <Goods> goodsList = goodsService.findAllGoods();
		System.out.println(goodsList);
		return goodsList;
	}
	
	
	
}
