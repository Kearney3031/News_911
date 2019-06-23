package com.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.model.Topic;
import com.model.User;
import com.service.TopicService;
import com.service.UserService;

@Controller

@RequestMapping("/topic")
public class TopicController {
	@Autowired
	private UserService userService;
	@Autowired
	private TopicService topicService;
	
	@RequestMapping(value = "/addTopic")
	public ModelAndView findAllType(String tname,String tcontent,HttpServletRequest req) {
		ModelAndView mo=new ModelAndView("redirect:/front/user/editor.jsp");
		Topic t=new Topic();
		t.setTopicName(tname);
		t.setTopicContent(tcontent);
		User u=(User) req.getSession().getAttribute("user");
		System.out.println(u.getUserName());
		System.out.println(u.getUserId());
		t.setUserId(u.getUserId());
		topicService.addTopic(t);
		return mo;
	}
	@RequestMapping(value = "/display")
	public ModelAndView display(int id,HttpServletRequest req) {
		ModelAndView mo=new ModelAndView("redirect:/front/topic/display.jsp");
		 Topic topic=topicService.findTopicById(id);
		
		req.getSession().setAttribute("user1", userService.findUserById(topic.getUserId()));
		req.getSession().setAttribute("topic", topic);
		
		return mo;
	}
	
	//分页展示所有话题
		@RequestMapping("/showAllTopic")
		public String showAllTopic(@RequestParam(value="pageNumber",required=false)Integer pageNumber,
				                    Map<String, Object> map) {
			int pageNumberTemp=1;//第一次访问页面没有传递参数，默认为1，且pageNumber默认为0
			int pageSize=4;
			if(pageNumber!=null) {
				pageNumberTemp=pageNumber;
			}
			map.put("pageBean", topicService.selTopicByPage(pageNumberTemp, pageSize));
			return "manage/showTopic";
		}
		
		//删除话题
		@RequestMapping("/deleteTopic")
		@ResponseBody
		public String deleteTopic(@RequestParam("topicId")Integer topicId,OutputStream os) {
			try {
				topicService.deleteTop(topicId);
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
