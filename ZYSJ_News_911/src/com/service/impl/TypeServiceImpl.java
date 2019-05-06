package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.TypeMapper;
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
}
