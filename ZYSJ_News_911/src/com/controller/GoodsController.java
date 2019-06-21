package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.model.Goods;
import com.model.Message;
import com.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping(value = "/findAll")
	public ModelAndView findAllGoods() {
		List<Goods> goodsList = goodsService.findAllGoods();
		ModelAndView mo=new ModelAndView("/front/goods/list");
		mo.addObject("goods", goodsList);
		return mo;
		
	}
	@RequestMapping(value = "/addGoods")
	@ResponseBody
	public String addGoods(Goods goods) {
		System.out.println(goods.getGoodsId());
		System.out.println(goods.getGoodsName());
		System.out.println(goods.getGoodsPrice());
		System.out.println(goods.getGoodsImg());
		System.out.println(goods.getGoodsInfo());
		goodsService.addGoods(goods);
		System.out.println("添加成功！！");
		return "redirect:/user/find.do";

		}
	
	@RequestMapping(value = "/delete") 
	@ResponseBody
	public void delGoods(String id) {
		goodsService.delGoods(Integer.parseInt(id));
		System.out.println(id + "号商品删除成功");
	}
}
