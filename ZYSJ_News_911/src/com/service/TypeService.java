package com.service;

import java.util.List;

import com.model.PageBean;
import com.model.Type;

public interface TypeService {
	List<Type> findAllType();
	List<Type> findByTypeId(int typeId);
	Type findByTypeId2(int typeId);
	
	//分页查询，把查询结果封装到一个PageBean中
	PageBean selTypeByPage(int pageNumber,int pageSize);
		
	//查询所有type显示到前台页面
	List<Type> findAllTypeToFront();
		
	int addType(Type type);
		
	int updType(Type type);
		
	int delType(int typeId);
}
