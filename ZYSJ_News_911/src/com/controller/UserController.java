package com.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.model.Collect;
import com.model.Feedback;
import com.model.News;
import com.model.Subscribe;
import com.model.Type;
import com.model.User;
import com.service.UserService;
import com.util.RandomNum;
import com.util.sendemail;
import com.util.webMes;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;


	

	@RequestMapping(value = "/sendmail", method = RequestMethod.POST)
	@ResponseBody
	public List<String> send(String email) {
		System.out.println("111");
		System.out.println(email);
		String code = new RandomNum().getRandom();
		sendemail.send(code, email);
		List<String> list = new ArrayList<>();
		list.add(code);
		return list;

	}
	@RequestMapping(value = "/buy")
	
	public String buyGoods(int price,HttpServletRequest req) {
		User u=(User) req.getSession().getAttribute("user");
		userService.buy(u.getUserId(), price);
		return "redirect:/goods/findAll.do";

	}
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public void edit(@RequestParam(value = "userRealName", required = false) String rname,
			@RequestParam(value = "phone", required = false) String phone,String temp,HttpServletRequest req) {
		System.out.println(temp);
		System.out.println("223123123");
		User user=(User) req.getSession().getAttribute("user");
		if(temp.equals("0")) {
			userService.updateRealName(user.getUserId(), rname);
			user.setUserRealName(rname);
			req.setAttribute("user", user);
		}
		else {
			userService.updatePhone(user.getUserId(), phone);
			user.setPhone(phone);
			req.setAttribute("user", user);
			
		}
		
		
		

	}
	@RequestMapping(value = "/feedback", method = RequestMethod.POST)
	@ResponseBody
	public void send(Feedback fb,HttpServletRequest req) {
				fb.setFeedbackContent(fb.getFeedbackContent()); 
		
		User user=(User) req.getSession().getAttribute("user");
		
		fb.setUserId(user.getUserId());
		fb.setFbTime(new Date(System.currentTimeMillis()));
		userService.addFeedback(fb);
		

	}

	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	@ResponseBody
	public void addUser(User user, HttpServletRequest request) throws UnsupportedEncodingException {
		System.out.println(user.getUserName());
		user.setUserRealName(new String(user.getUserRealName().getBytes("ISO-8859-1"), "utf-8"));
		userService.addUser(user);
		
		
	
		

	}
	@RequestMapping(value = "/quit", method = RequestMethod.GET)
	public String quit(HttpServletRequest request) throws UnsupportedEncodingException {
		request.getSession().removeAttribute("user");
		
		
		return "redirect:/front/zhuye.jsp";
		
	
		

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public List<String> testLogin(@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "password") String psw, HttpServletRequest request,HttpServletResponse response) {
		
		List<String> status = new ArrayList<>();
		if (email == null) {
			User u = new User();
			u.setUserName(username);
			u.setPassword(psw);
			User u1 = userService.testLogin(u);
			if (u1 == null) {
				status.add("error");
				return status;

			}
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
			request.getSession().setAttribute("user", u1);
			
			if(u1.getUserType()==1) {
				status.add("success");
				}
				else if(u1.getUserType()==2) {
					status.add("suc1");
				}
			return status;

		} else {
			User u = new User();
			u.setEmail(email);
			u.setPassword(psw);
			User u1 = userService.testLogin1(u);
			System.out.println(u1);
			if (u1 == null) {
				status.add("error");
				return status;
			}

			request.getSession().setAttribute("user", u1);
			
			if(u1.getUserType()==1) {
			status.add("success");
			}
			else if(u1.getUserType()==2) {
				status.add("suc1");
			}
			System.out.println();
			return status;
		}

	}

	
	@RequestMapping(value = "/login1", method = RequestMethod.POST)
	@ResponseBody
	public List<String> testLogin1(@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "password") String psw, HttpServletRequest request,HttpServletResponse response) {
		
		List<String> status = new ArrayList<>();
		
			User u = new User();
			u.setUserName(username);
			u.setPassword(psw);
			User u1 = userService.testLogin(u);
			
			if (u1 == null||u1.getUserType()!=3) {
				status.add("error");
				return status;

			}
			
			
			
			else {status.add("success");}
			
			return status;

		 

	}
	
	
	
	
	@RequestMapping(value = "/findUserById")
	@ResponseBody
	public User findUserById(String userId) {
		User u1= new User();
		u1.setUserId(3);
		User user = userService.findUserById(u1.getUserId());
		System.out.println(user);
		return user;
	}

	@RequestMapping(value = "/findut")
	@ResponseBody
	public List<User> findAllUserAndType() {
		List<User> users = userService.findUserType();
		// System.out.println(users);
		for (User u : users) {
			System.out.println(u.getTypes());
			
		}
		return users;

		
	}

	@RequestMapping(value = "/findUserTypeByUserId")
	@ResponseBody
	public List<User> findUserTypeByUserId(String userId) {
		// int userId_int = Integer.parseInt(userId);
		List<User> users = userService.findUserTypeByUserId(3);
		// System.out.println(users);
		for (User u : users) {
			System.out.println(u.getTypes());
		}
		return users;
	}

	// @Transactional
	@RequestMapping(value = "/addUserType")
	//@ResponseBody
	// @RequestParam(value = "Integer") List<Integer> typeIds
	public String addUserType(HttpServletRequest request) {
//		userId = 3;
//		List<Integer> typeIds = new ArrayList<>();
//		typeIds.add(6);
//		typeIds.add(7);
//		User u1 = new User();
//		u1.setUserId(userId);
//		Type t1 = new Type();
		//HttpSession session = request.getSession();
		String[] typeIds = request.getParameterValues("Type");
		int[] newTypeIds = new int[typeIds.length];
		for(int i=0;i<typeIds.length;i++) {
			newTypeIds[i]=Integer.valueOf(typeIds[i]); 
		}
		User u1 = new User();
		u1.setUserId(Integer.valueOf(request.getParameter("userId")));
		userService.deleteUserType(u1.getUserId());//Integer.valueOf(userId)
		Type t1 = new Type();
		for (Integer typeId : newTypeIds) {
			Subscribe subscribe = new Subscribe();
			subscribe.setUser(u1);
			t1.setTypeId(typeId);
			subscribe.setType(t1);
			userService.addUserType(subscribe);
		}
		System.out.println("订阅成功");
		return "redirect:/front/zhuye.jsp";
	}

	@RequestMapping(value = "/findUserNewsByUserId")
	@ResponseBody
	public ModelAndView findUserNewsByUserId(String userId) {
		
		List<User> users = userService.findUserNewsByUserId(Integer.valueOf(userId));
		System.out.println(users);
		for (User u : users) {
			System.out.println(u.getNewsList());
		}
		ModelAndView mo = new ModelAndView("/front/news/collect");
		mo.addObject("user", users.get(0));
		return mo;
	}

	@RequestMapping(value = "/addUserCollectNews")
	@ResponseBody
	public void addUserCollectNews(String userId,String newsId) {
		News news = new News();
		news.setNewsId(Integer.valueOf(newsId));
		User user = new User();
		user.setUserId(Integer.valueOf(userId));
		Collect collect = new Collect();
		collect.setNews(news);
		collect.setUser(user);
		userService.addUserCollectNews(collect);
		System.out.println("收藏成功！");
	}
	@RequestMapping(value = "/deleteUserCollectNews")
	@ResponseBody
	public void deleteUserCollectNews(String newsId, String userId) {
		News news = new News();
		news.setNewsId(Integer.valueOf(newsId));
		User user = new User();
		user.setUserId(Integer.valueOf(userId));
		Collect collect = new Collect();
		collect.setNews(news);
		collect.setUser(user);
		userService.deleteUserCollectNews(collect);
		System.out.println("取消收藏成功");
	}
	

	//分页展示所有user
    @RequestMapping("/showAllUser")
	public ModelAndView showAllUser(@RequestParam(value="pageNumber",required=false)Integer pageNumber) {
		int pageNumberTemp=1;//第一次访问页面没有传递参数，默认为1，且pageNumber默认为0
		int pageSize=4;
		if(pageNumber!=null) {
			pageNumberTemp=pageNumber;
		}
		ModelAndView mv=new ModelAndView("/manage/showUser");
		mv.addObject("pageBean", userService.selUserByPage(pageNumberTemp, pageSize));
		return mv;
	}
		
	//删除user
	@RequestMapping("/deleteUser")
	@ResponseBody
	public String deleteUser(@RequestParam("userId")Integer userId,OutputStream os) {
		try {
			userService.delUser(userId);
			os.write("1".getBytes("UTF-8"));//返回1代表删除成功
		} catch (Exception e) {
				  e.printStackTrace();
			try {
				os.write("0".getBytes("UTF-8"));//返回0代表删除失败
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	    }
		return null;
	}
	
}
