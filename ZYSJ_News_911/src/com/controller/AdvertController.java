package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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
	public ModelAndView findAllAdvert() {
		List<Advert> advertList = advertService.findAllAdvert();
		ModelAndView mo=new ModelAndView("/manage/delAdvert");
		mo.addObject("adverts", advertList);
		return mo;
	}
	@RequestMapping(value = "/addAdvert")
	public String addAdvert(@RequestParam(value = "advertImg") MultipartFile file, String advertLink,String name,HttpServletRequest req) {
		Advert a=new Advert();

		String path = req.getServletContext().getRealPath("/images");
		String uploadFileName1 = System.currentTimeMillis() + file.getName();
		File file11 = new File(path, uploadFileName1 + ".png");
			try {
				file.transferTo(file11);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			a.setAdvertImg( "/images/" + uploadFileName1 + ".png");
		a.setAdvertLink(advertLink);
		a.setAdvertName(name);
		advertService.addAdvert(a);
		System.out.println("广告添加成功！！");
		return "forward:findAll.do";

		}
	
	@RequestMapping(value = "/delete")
	public String delAdvert(String id) {
		advertService.delAdvert(Integer.parseInt(id));
		System.out.println(id + "号广告删除成功");
		return "forward:findAll.do";
	}
}
