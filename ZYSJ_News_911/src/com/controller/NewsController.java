package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.service.TopicService;
import com.service.TypeService;
import com.service.UserService;
import com.service.VideoService;
import com.util.webMes;

@Controller
@RequestMapping("/news")
public class NewsController {
	@Autowired
	private TopicService topicService;
	
	@Autowired
	private UserService userService;
	@Autowired
	private TypeService typeService;
	@Autowired
	private NewsService newsService;
	@Autowired
	private VideoService videoService;
	
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
	User user= (User)request.getSession().getAttribute("user");
	
		News new1=new News();
	new1.setNewsImg( "/images/" + uploadFileName1 + ".png");
	new1.setNewsContent(newscontent1);
	new1.setNewsLike(0);
	new1.setNewsTitle(newstitle1);
	new1.setTypeId(Integer.valueOf(newstype));
	new1.setNewStatus(0);
	new1.setPublishTime(new Date(System.currentTimeMillis()));
	new1.setUserId(user.getUserId());
	
	newsService.addNews(new1);

		return "redirect:/front/user/editor.jsp";

	}
	
	@RequestMapping(value = "/findByPage")
	public ModelAndView findByPage(@RequestParam(value="page",required=false)Integer page,HttpServletRequest request,HttpServletResponse response) {
		webMes webmes=new webMes();
		List list=null;
		try {
			 list=webmes.getAdd(request,response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getSession().setAttribute("country",String.valueOf(list.get(0)));
		request.getSession().setAttribute("pro", String.valueOf(list.get(1)));
		request.getSession().setAttribute("city", String.valueOf(list.get(2)));
		request.getSession().setAttribute("time", String.valueOf(list.get(3)));
		request.getSession().setAttribute("today", String.valueOf(list.get(4)));
		request.getSession().setAttribute("now", String.valueOf(list.get(5)));
		
		
//		 List<News> news = newsService.findByPage(page, 2);
//		System.out.println(news.size());
		int totalPage=newsService.findTotalPage(2);
		ModelAndView mo=new ModelAndView("/front/index");
		mo.addObject("list1", topicService.findAllTopic());
		mo.addObject("list2", videoService.findAllVideo());
		
	//	mo.addObject("page", page);
	//	mo.addObject("totalPage", totalPage);
		
		if (page!=null) {//说明是第一次展示,page是页面传来的
		   List<News> news = newsService.findByPage(page, 2);
		   mo.getModel().put("page", page);
           mo.addObject("list", news);
		} else {         //为空就说明已经是关键字查询或者分类浏览了，page从session中获取
            page=(Integer) request.getSession().getAttribute("page");
            List<News> KeyNews=(List<News>) request.getSession().getAttribute("KeyNews");
            List<News> mynews=(List<News>) request.getSession().getAttribute("mynews");
            mo.addObject("KeyNews",KeyNews);
            mo.addObject("mynews",mynews);
            mo.getModel().put("page", page);
		}
		
		mo.getModel().put("totalPage", totalPage);
		mo.addObject("hot", newsService.findHotNews());
		mo.addObject("point", newsService.findPointNews());
		mo.getModel().put("types",typeService.findAllTypeToFront());
		
			 
		return mo;
		
	}
	@RequestMapping(value = "/display")
	public ModelAndView display(int  id,HttpServletRequest req) {
		News news1=newsService.findNewsByNewsId(id);
		//ModelAndView mo=new ModelAndView("/front/news/display");
		ModelAndView mo=new ModelAndView("forward:addCookieNews.do?newsId="+news1.getNewsId());
		req.getSession().setAttribute("news", news1);
		req.getSession().setAttribute("name", userService.findUserById(news1.getUserId()).getUserRealName());
//		mo.addObject("news", news1);
//		mo.addObject("name", userService.findUserById(news1.getUserId()).getUserRealName());
		
		return mo;
	}
	//提交新闻的预操作，首先先得到所有的新闻类型。
	@RequestMapping(value = "/preAddNews")
	public ModelAndView pAddNews() {
		List<Type> list=typeService.findAllType();
		ModelAndView mo=new ModelAndView("/front/news/newsUpload");
		mo.addObject("list", list);
		return mo;
	}
	@RequestMapping(value = "/findAll")
	public ModelAndView findAll() {
		List<News> list=newsService.findAll();
		ModelAndView mo=new ModelAndView("/manage/news");
		mo.addObject("list", list);
		return mo;
	}
	@RequestMapping(value = "/passNews")
	public ModelAndView passNews(int id) {
		newsService.passNews(id);
		List<News> list=newsService.findAll();
		ModelAndView mo=new ModelAndView("/manage/news");
		mo.addObject("list", list);
		return mo;
	}
	
	@RequestMapping(value = "/addCookieNews")
	public ModelAndView addCookieNews(HttpServletRequest request,HttpServletResponse response,ModelAndView mo) {
		//String newsId = request.getParameter("news");
		String newsId = request.getParameter("newsId");
		System.out.println("11111"+newsId);
		 Cookie[] cookies=  request.getCookies();
			 String cookieValue = buildCookie(newsId,request);
			  Cookie cookie = new Cookie("newsId",cookieValue);
			  cookie.setMaxAge(30*24*60*60);
			  cookie.setPath("/");
		      response.addCookie(cookie);
		      System.out.println(cookieValue);
		      
		      mo.setViewName("redirect:/front/news/display.jsp");
		      return mo;
	} 
	
	
	@RequestMapping(value = "/findNewsByCookies")
	public ModelAndView findNewsByCookies(HttpServletRequest request,HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		List<News> historyNewsList = new ArrayList<>();
for (int i = 0; cookies != null && i < cookies.length; i++){
			
			//找到我们想要的cookie
			if (cookies[i].getName().equals("newsId")){
				String[] pids = cookies[i].getValue().split("-");
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
		ModelAndView mo = new ModelAndView("/front/news/history");
		//request.setAttribute("list", historyNewsList);
		mo.addObject("list",historyNewsList);
		return mo;
		
	}
	
	
	private String buildCookie(String id, HttpServletRequest request) {
		 String productId = null;
	        Cookie [] cookies = request.getCookies();
	        for(int i = 0; cookies!=null && i < cookies.length; i++){
	        	productId = cookies[i].getValue();
	        }
	          
	        if(productId==null)
	            return id;
	          
	        LinkedList<String> list = new LinkedList<String>(Arrays.asList(productId.split("-")));
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
	
	
	  //分类浏览
	  @RequestMapping("/showNewsByType") 
	  public String showNewsByType(@RequestParam("typeId")int typeId,
			                       @RequestParam("page")int page,
			                       HttpSession session) {
	       session.setAttribute("mynews",newsService.showNewsByTypeId(typeId)); 
	       session.setAttribute("page", page);
	       return "redirect:/news/findByPage.do"; 
	 }
	 
	 
		
	//关键字查询
	@RequestMapping("/showNewsByKey")
	public String showNewsByKey(@RequestParam("newsTitle")String newsTitle,
			                    @RequestParam("page")int page,
			                    HttpSession session) {
		session.setAttribute("KeyNews", newsService.showNewsByKeyValue(newsTitle));
		session.setAttribute("page", page);
		return "redirect:/news/findByPage.do";
			
	}
	
}
