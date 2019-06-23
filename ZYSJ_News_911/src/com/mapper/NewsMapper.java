package com.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.model.News;

public interface NewsMapper {
	 void addNews(News news);//新闻提交
	
	 void addLike(int id);//点赞
	 List<News> findByPage(Map<String, Integer> map);//返回一页新闻

	 //这是管理员用的findAll
	 List<News> findAll();
	 int getCount();//返回一共有多少个新闻
	 //新闻审核通过
	void passNews(int id);
	void dispassNews(int id);

	 
	List<News> findHotNews();
	List<News> findPointNews();
	 News findNewsByNewsId(int id);
	 
	//通过typeId查询对应类型的news,完成分类浏览
	@Select("select * from news where typeId=#{param1}")
	List<News> findNewsByTypeId(int typeId);
		 
    //关键字查询，即模糊查询，可能包含不止一条记录
	@Select("select * from news where newsTitle like concat(concat('%', #{param1}), '%')")
	List<News> findNewsByKeyValue(String newsTitle);


}
