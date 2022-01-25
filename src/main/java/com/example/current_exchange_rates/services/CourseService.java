package com.example.current_exchange_rates.services;

import com.example.current_exchange_rates.entity.CourseEntity;

import java.util.List;

public interface CourseService {

    List<CourseEntity> getAllHistory();

    CourseEntity getById(String id);

    CourseEntity create(CourseEntity courseEntity);

}
