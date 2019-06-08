package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Type;
import com.service.TypeService;

@Controller

@RequestMapping("/type")
public class TypeController {
	@Autowired
	private TypeService typeService;
	
	@RequestMapping(value = "/find")
	//@ResponseBody
	public String findAllType(HttpServletRequest request) {//List<Type> 
		List<Type> types= typeService.findAllType();
		HttpSession session = request.getSession();
		System.out.println(types);
		//return types;
		session.setAttribute("listType", types);
		return "redirect:/TypeChoose.jsp";
	}
}
