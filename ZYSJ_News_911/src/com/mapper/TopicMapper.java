package com.mapper;

import java.util.List;

import com.model.Topic;

public interface TopicMapper {
void addTopic(Topic t);
List<Topic> findAllTopic();

Topic findTopicById(int id);

}
