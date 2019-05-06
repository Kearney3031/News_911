package com.controller;

import java.util.List;

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
	@ResponseBody
	public List<Type> findAllType() {
		List<Type> types= typeService.findAllType();
		System.out.println(types);
		return types;
	}
}
