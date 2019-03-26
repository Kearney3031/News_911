package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Message;
import com.service.MessageService;

@Controller

@RequestMapping("/message")
public class MessageController {
@Autowired
private MessageService messageService;
@RequestMapping(value = "/find")
@ResponseBody
public String findAllUser(HttpServletRequest request) {
		List<Message> messages = messageService.findAllMessage();
		HttpSession session = request.getSession();
		System.out.println(messages);
		session.setAttribute("listMessage", messages);
		return "redirect:/message.jsp";
	}

}
