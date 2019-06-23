package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.model.Goods;
import com.model.Message;
import com.model.News;
import com.model.User;
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
	@RequestMapping(value = "/findAll1")
	public ModelAndView findAllGoods1() {
		List<Goods> goodsList = goodsService.findAllGoods();

		ModelAndView mo=new ModelAndView("/manage/delGoods");
		mo.addObject("goods", goodsList);
		return mo;
	}
	@RequestMapping(value = "/addGoods")
	public String addGoods(@RequestParam(value = "goodsimg") MultipartFile file, String name, String price,
			String goodinfo, HttpServletRequest request) {
		
		
		
		String path = request.getServletContext().getRealPath("/images");
		String uploadFileName1 = System.currentTimeMillis() + file.getName();
		File file11 = new File(path, uploadFileName1 + ".png");
		try {
			file.transferTo(file11);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		Goods g=new Goods();
		g.setGoodsImg("/images/" + uploadFileName1 + ".png");
		g.setGoodsInfo(goodinfo);
		g.setGoodsName(name);
		g.setGoodsPrice(Integer.parseInt(price));
		goodsService.addGoods(g);

		return "forward:findAll1.do";

	}
	
	@RequestMapping(value = "/delete") 
	public String delGoods(int  id) {
		goodsService.delGoods(id);
		System.out.println(id + "号商品删除成功");
		return "forward:findAll1.do";
	}
}
