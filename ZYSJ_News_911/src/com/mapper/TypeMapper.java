package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.model.Type;

public interface TypeMapper {
	List<Type> findAllType();

	List<Type> findByTypeId(int typeId);
	
	Type findByTypeId2(int typeId);
	
	//分页查询所有类型
		@Select("select * from type limit #{param1},#{param2}")
		List<Type> findAllTypeByPage(int pageStart,int pageSize);
		
		//查询类型表的总记录数
		@Select("select count(*) from type")
		long count();
		
		//增加类型
		@Insert("insert into type values(default,#{typeName},#{typeIntroduce})")
		int insertType(Type type);
		
		//修改类型
		@Update("update type set typeName=#{typeName},typeIntroduce=#{typeIntroduce} where typeId = #{typeId}")
		int updateType(Type type);
		
		//删除类型
		@Delete("delete from type where typeId=#{param1}")
		int deleteType(int typeId);
}
