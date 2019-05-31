package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.model.News;
import com.model.User;
import com.service.NewsService;
import com.service.UserService;

@Controller
@RequestMapping("/news")
public class NewsController {
	
	@Autowired
	private NewsService newsService;
	
	@RequestMapping(value = "/NewsUpload")
	public String addNews(@RequestParam(value = "newsimg") MultipartFile file, String newstitle, String newstype,
			String newscontent, HttpServletRequest request) {

		byte[] b, c;
		String newstitle1 = "";
		String newscontent1 = "";
		try {
			b = newstitle.getBytes("ISO-8859-1");// 用tomcat的格式（iso-8859-1）方式去读。
			newstitle1 = new String(b, "utf-8");// 采用utf-8去接string
			c = newscontent.getBytes("ISO-8859-1");// 用tomcat的格式（iso-8859-1）方式去读。
			newscontent1 = new String(b, "utf-8");// 采用utf-8去接string
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String path = request.getServletContext().getRealPath("/img");
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
	User user= (User)request.getSession().getAttribute("user");
	int newstype1=Integer.valueOf(newstype);
		News new1=new News(newstitle1, newscontent1, path + "/" + uploadFileName1 + ".png", 0, user.getUserId(), 0, newstype1,  new Date(System.currentTimeMillis()));
	newsService.addNews(new1);

		return "redirect:/file/show.html";

	}
	
}
