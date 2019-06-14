package com.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.model.Topic;
import com.model.Type;
import com.model.User;
import com.service.TopicService;
import com.service.TypeService;
import com.service.UserService;

@Controller

@RequestMapping("/topic")
public class TopicController {
	@Autowired
	private UserService userService;
	@Autowired
	private TopicService topicService;
	
	@RequestMapping(value = "/addTopic")
	public ModelAndView addTopic(String tname,String tcontent,HttpServletRequest req) {
		ModelAndView mo=new ModelAndView("redirect:/front/user/editor.jsp");
		Topic t=new Topic();
		t.setTopicName("#"+tname);
		t.setTopicContent(tcontent);
		User u=(User) req.getSession().getAttribute("user");
		System.out.println(u.getUserName());
		System.out.println(u.getUserId());
		t.setUserId(u.getUserId());
		topicService.addTopic(t);
		return mo;
	}
	@RequestMapping(value = "/display")
	public ModelAndView display(int id) {
		ModelAndView mo=new ModelAndView("/front/topic/display");
		 Topic topic=topicService.findTopicById(id);
		mo.addObject("user", userService.findUserById(topic.getUserId()));
		
		mo.addObject("topic", topic);
		return mo;
	}
	
	
	
}
