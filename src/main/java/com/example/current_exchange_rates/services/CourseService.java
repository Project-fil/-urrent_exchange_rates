package com.example.current_exchange_rates.services;

import com.example.current_exchange_rates.entity.CourseEntity;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface CourseService {

    List<CourseEntity> getAllHistory(Sort sort);

    CourseEntity create(CourseEntity courseEntity);

}
