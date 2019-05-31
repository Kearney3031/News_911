package com.mapper;

import java.util.List;

import com.model.Type;

public interface TypeMapper {
	List<Type> findAllType();

	List<Type> findByTypeId(int typeId);
}
