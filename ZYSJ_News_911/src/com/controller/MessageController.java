package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Message;
import com.service.MessageService;
import com.service.UserService;

@Controller

@RequestMapping("/message")
public class MessageController {
	@Autowired
	private MessageService messageService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/find")
//@ResponseBody
	public String findAllUser(HttpServletRequest request) {
		List<Message> messages = messageService.findAllMessage();
		HttpSession session = request.getSession();
		System.out.println(messages);
		session.setAttribute("listMessage", messages);
		return "redirect:/showMessage.jsp";
	}

	@RequestMapping(value = "/find2")
	@ResponseBody
	public List<Message> findAllUser2() {
		//List<Message> messages = messageService.findAllMessage();
		List<Message> messages = messageService.findAllMessage();
		// System.out.println(messages);
		System.out.println(messages);
		return messages;
	}

	@RequestMapping(value = "/findByUserId")
	@ResponseBody
	public List<Message> findByUserId(String id) {
		int id1 = 2;
		List<Message> messages = messageService.findByUserId(id1);
		return messages;
	}

	@RequestMapping(value = "/insert")
	public void addMessage(Message message) {
		System.out.println(message.getTime());
		System.out.println(message.getUserId());
		messageService.addMessage(message);
		System.out.println("评论成功");
		userService.addUserScore(message.getUserId());
		System.out.println(message.getUserId()+"号用户积分加1");
	}
	@RequestMapping(value = "/delete") 
	@ResponseBody
	public void delMessage(String id) {
		messageService.delMessage(Integer.parseInt(id));
		System.out.println(id + "号评论删除成功");
	}

	@Transactional
	@RequestMapping(value = "/addLike")
	public void addLike(String id) {
		messageService.addLike(Integer.parseInt(id));
		System.out.println(id + "号点赞成功");
	}

	@RequestMapping(value = "/subLike")
	public void subLike(String id) {
		messageService.subLike(Integer.parseInt(id));
		System.out.println(id + "号取消赞成功!");
	}
	
	@RequestMapping(value = "/findMessageByNewsId")
	@ResponseBody
	public List<Message> findMessageByNewsId(String id){
		System.out.println(id);
		List<Message> message = messageService.findMessageByNewsId(Integer.valueOf(id));
		System.out.println(message);
		return message;
	}
	
	@RequestMapping(value = "/findMessageByVideoId")
	@ResponseBody
	public List<Message> findMessageByVideoId(String id){
		System.out.println(id);
		List<Message> message = messageService.findMessageByVideoId(Integer.valueOf(id));
		System.out.println(message);
		return message;
	}
	
	@RequestMapping(value = "/findMessageByTopicId")
	@ResponseBody
	public List<Message> findMessageByTopicId(String id){
		System.out.println(id);
		List<Message> message = messageService.findMessageByTopicId(Integer.valueOf(id));
		System.out.println(message);
		return message;
	}
	
}
