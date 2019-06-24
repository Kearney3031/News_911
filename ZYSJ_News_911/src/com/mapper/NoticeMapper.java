package com.mapper;

import java.util.List;

import com.model.Notice;
import com.model.Topic;

public interface NoticeMapper {
void update(String content);
List<Notice> find();
}
