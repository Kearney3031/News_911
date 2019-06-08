package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.model.News;
import com.model.Type;
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
		News new1=new News();
	new1.setNewsImg( path + "/" + uploadFileName1 + ".png");
	new1.setNewsContent(newscontent1);
	new1.setNewsLike(0);
	new1.setNewsTitle(newstitle1);
	new1.setNewsTitle(newstitle1);
	new1.setNewStatus(0);
	new1.setPublishTime(new Date(System.currentTimeMillis()));
	new1.setUserId(user.getUserId());
	
	newsService.addNews(new1);

		return "redirect:/file/show.html";

	}
	
	
	 
	@RequestMapping(value = "/findByPage")
	public ModelAndView findByPage(int  page) {
		System.out.println(page);
		
	
		
		List<News> news = newsService.findByPage(page, 1);
		System.out.println(news.size());
		int totalPage=newsService.findTotalPage(1);
	ModelAndView mo=new ModelAndView("/front/index");
	mo.addObject("list", news);
//	mo.addObject("page", page);
//	mo.addObject("totalPage", totalPage);
	mo.getModel().put("page", page);
	mo.getModel().put("totalPage", totalPage);
		return mo;
	}
	
	@RequestMapping(value = "/addCookieNews")
	public String addCookieNews(HttpServletRequest request,HttpServletResponse response) {
		String newsId = request.getParameter("");
		 Cookie[] cookies=  request.getCookies();
			 String cookieValue = buildCookie(newsId,request);
			  Cookie cookie = new Cookie("newsId",cookieValue);
			  cookie.setMaxAge(30*24*60*60);
			  cookie.setPath("/");
		      response.addCookie(cookie);
		      System.out.println(cookieValue);
			return "redirect:/history.jsp";
	} 
	
	
	@RequestMapping(value = "/findTypeByCookies")
	public String findNewsByCookies(HttpServletRequest request,HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		List<News> historyNewsList = new ArrayList<>();
for (int i = 0; cookies != null && i < cookies.length; i++){
			
			//找到我们想要的cookie
			if (cookies[i].getName().equals("newsId")){
				String[] pids = cookies[i].getValue().split("\\-");
				int[] newNewsIds = new int[pids.length];
				News news = new News();
				System.out.println(pids.toString());
				for (int j=0;j<pids.length-1;j++){
					newNewsIds[j]=Integer.valueOf(pids[j]); 
					news = newsService.findNewsByNewsId(newNewsIds[j]);
					historyNewsList.add(news);
					System.out.println(newNewsIds[j]+":"+news);
				}
			}
		}
		System.out.println(historyNewsList);
		request.setAttribute("historyNewsList", historyNewsList);
		return null;
		
	}
	
	
	private String buildCookie(String id, HttpServletRequest request) {
		 String productId = null;
	        Cookie [] cookies = request.getCookies();
	        for(int i = 0; cookies!=null && i < cookies.length; i++){
	        	productId = cookies[i].getValue();
	        }
	          
	        if(productId==null)
	            return id;
	          
	        LinkedList<String> list = new LinkedList<String>(Arrays.asList(productId.split("\\-")));
	        if(list.contains(id)){
	            list.remove(id);
	        }else{
	            if(list.size()>=5){
	                list.removeLast();
	            }
	        }
	        list.addFirst(id);
	          
	        StringBuffer sb = new StringBuffer();
	        for(String bid: list){
	            sb.append(bid + "-");
	        }
	        return sb.deleteCharAt(sb.length()-1).toString();//删除最后多余 的一个逗号
	    }
	
}
