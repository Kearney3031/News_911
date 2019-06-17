package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.model.Advert;
import com.model.Goods;
import com.model.Message;
import com.model.Topic;
import com.model.User;
import com.service.AdvertService;
import com.service.UserService;

@Controller
@RequestMapping("/advert")
public class AdvertController {

	@Autowired
	private AdvertService advertService;
	
	
	@RequestMapping(value = "/findAll")
	//@ResponseBody
	public List<Advert> findAllAdvert() {
		List <Advert> advertList = advertService.findAllAdvert();
		System.out.println(advertList);
		return advertList;
	}
	@RequestMapping(value = "/addAdvert")
	@ResponseBody
	public String addAdvert(Advert advert) {
		System.out.println(advert.getAdvertId());
		System.out.println(advert.getAdvertName());
		System.out.println(advert.getAdvertImg());
		System.out.println(advert.getAdvertLink());
		advertService.addAdvert(advert);
		System.out.println("广告添加成功！！");
		return "redirect:/user/find.do";

		}
	
	@RequestMapping(value = "/delete") 
	@ResponseBody
	public void delAdvert(String id) {
		advertService.delAdvert(Integer.parseInt(id));
		System.out.println(id + "号广告删除成功");
	}
}
