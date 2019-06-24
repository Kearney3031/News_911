package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import com.model.News;
import com.model.Topic;

public interface TopicMapper {
void addTopic(Topic t);
List<Topic> findAllTopic();
List<Topic> All(int id);
Topic findTopicById(int id);

//分页查询所有话题
@Select("select * from topic limit #{param1},#{param2}")
List<Topic> findAllTopicByPage(int pageStart,int pageSize);

//总记录数
@Select("select count(*) from topic")
long count();

//删除话题
@Delete("delete from topic where topicid=#{param1}")
void delTopic(int topicId);

}
