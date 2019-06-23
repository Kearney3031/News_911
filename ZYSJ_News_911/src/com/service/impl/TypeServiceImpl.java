package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.TypeMapper;
import com.model.PageBean;
import com.model.Type;
import com.service.TypeService;
@Service
@Transactional
public class TypeServiceImpl implements TypeService {
	@Autowired
	public TypeMapper typeMapper;
	
	@Override
	public List<Type> findAllType() {
		List<Type> types = typeMapper.findAllType();
		return types;
	}
	@Override
	public List<Type> findByTypeId(int typeId){
		List<Type> types = typeMapper.findByTypeId(typeId);
		return types;
	}
	@Override
	public Type findByTypeId2(int typeId) {
		Type type = typeMapper.findByTypeId2(typeId);
		return type;
	}
	
	@Override
	public int addType(Type type) {
		return typeMapper.insertType(type);
	}
	@Override
	public int delType(int typeId) {
		return typeMapper.deleteType(typeId);
	}
	
	@Override
	public PageBean selTypeByPage(int pageNumber, int pageSize) {
		PageBean pb=new PageBean();
		pb.setPageNumber(pageNumber);
		pb.setPageSize(pageSize);
		
		long count=typeMapper.count();
		pb.setTotalPage(count%pageSize==0? count/pageSize:(count/pageSize)+1);
		
		List<Type> typelist=typeMapper.findAllTypeByPage((pageNumber-1)*pageSize, pageSize);
		pb.setList(typelist);
		return pb;
	}
	
	@Override
	public int updType(Type type) {
		return typeMapper.updateType(type);
	}
	
	@Override
	public List<Type> findAllTypeToFront() {
		return typeMapper.findAllType();
	}
}
