package com.service;

import java.util.List;

import com.model.Type;

public interface TypeService {
	List<Type> findAllType();
	List<Type> findByTypeId(int typeId);
	Type findByTypeId2(int typeId);
}
