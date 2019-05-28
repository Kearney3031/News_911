package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FileUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.model.Collect;
import com.model.News;
import com.model.Subscribe;
import com.model.Type;
import com.model.User;

import com.service.UserService;
import com.util.RandomNum;
import com.util.sendemail;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String uploadVideo(@RequestParam(value = "upload", required = false) MultipartFile file,
			HttpServletRequest request) {

		System.out.println("111");
		User user = new User();

		request.getSession().setAttribute("user", user);

		String path = request.getServletContext().getRealPath("/file");
		System.out.println(path);
		System.out.println(file.getName());
		String uploadFileName1 = System.currentTimeMillis() + file.getName();
		File file11 = new File(path, uploadFileName1 + ".mp4");

		System.out.println(uploadFileName1);
		try {
			file.transferTo(file11);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// ModelAndView mav=new
		// ModelAndView("/show.html?fname="+uploadFileName1+".mp4");
//				mav.addObject("fname", uploadFileName1+".mp4");
		// mav.getModel().put("fname", uploadFileName1+".mp4");

		return "redirect:/file/show.html?fname=" + uploadFileName1 + ".mp4";

	}

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

		userService.addNews(newstitle1, newscontent1, path + "/" + uploadFileName1 + ".png", 0, 1, 0,
				Integer.parseInt(newstype), new Date(System.currentTimeMillis()));

		return "redirect:/file/show.html";

	}

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

	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	public String addUser(String username, String password, String realname, String phone, String email,
			String userType, HttpServletRequest request) throws UnsupportedEncodingException {

		User user = new User();
		user.setUserName(username);
		user.setPassword(password);
		realname = new String(realname.getBytes("ISO-8859-1"), "utf-8");
		user.setUserRealName(realname);

		user.setPhone(phone);
		user.setUserType(Integer.parseInt(userType));
		user.setEmail(email);
		userService.addUser(user);
		request.getSession().setAttribute("user", user);
		request.getSession().setAttribute("name", user.getUserRealName());
		ModelAndView mav = new ModelAndView("/index.jsp");
		mav.getModel().put("name", realname);
//	return mav;
		return "redirect:/front/user/index.jsp";

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public List<String> testLogin(@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "password") String psw, HttpServletRequest request) {
		System.out.println("1111");
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

			request.getSession().setAttribute("user", u1);
			request.getSession().setAttribute("name", u1.getUserRealName());
			status.add("success");
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
			request.getSession().setAttribute("name", u1.getUserRealName());
			status.add("success");
			System.out.println();
			return status;
		}

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
	@ResponseBody
	// @RequestParam(value = "Integer") List<Integer> typeIds
	public void addUserType(Integer userId) {
		userId = 3;
		List<Integer> typeIds = new ArrayList<>();
		typeIds.add(6);
		typeIds.add(7);
		User u1 = new User();
		u1.setUserId(userId);
		Type t1 = new Type();
		for (Integer typeId : typeIds) {
			Subscribe subscribe = new Subscribe();
			subscribe.setUser(u1);
			t1.setTypeId(typeId);
			subscribe.setType(t1);
			userService.addUserType(subscribe);
		}
		System.out.println("订阅成功");
	}

	@RequestMapping(value = "/findUserNewsByUserId")
	@ResponseBody
	public List<User> findUserNewsByUserId(String userId) {

		List<User> users = userService.findUserNewsByUserId(3);
		for (User u : users) {
			System.out.println(u.getNewsList());
		}
		return users;
	}

//	//@Transactional
	@RequestMapping(value = "/addUserCollectNews")
	@ResponseBody
	public void addUserCollectNews(Integer userId) {
		userId = 2;
		News news = new News();
		news.setNewsId(8);
		User user = new User();
		user.setUserId(userId);
		Collect collect = new Collect();
		collect.setNews(news);
		collect.setUser(user);
		userService.addUserCollectNews(collect);
		System.out.println("收藏成功！");
	}

//	//@Transactional
	@RequestMapping(value = "/deleteUserCollectNews")
	@ResponseBody
	public void deleteUserCollectNews(String newsId, String userId) {
//		newsId = 8;
//		userId = 2;
		News news = new News();
		news.setNewsId(8);
		User user = new User();
		user.setUserId(2);
		Collect collect = new Collect();
		collect.setNews(news);
		collect.setUser(user);
		userService.deleteUserCollectNews(collect);
		System.out.println("取消收藏成功");
	}
}
