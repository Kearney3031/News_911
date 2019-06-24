package com.controller;

import java.io.UnsupportedEncodingException;
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
import com.service.NoticeService;
import com.service.TopicService;
import com.service.TypeService;
import com.service.UserService;

@Controller

@RequestMapping("/notice")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;
	
	
	@RequestMapping(value = "/updateNotice")
	@ResponseBody
	public void updateNotice(String content) {

		noticeService.update(content);
	}
	
	
	
	
}
