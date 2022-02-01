package com.example.current_exchange_rates.services;

import com.example.current_exchange_rates.entity.CourseEntity;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.UUID;

public interface CourseService {

    List<CourseEntity> getAllHistory(Sort sort);

    CourseEntity getById(UUID id);

    CourseEntity create(CourseEntity courseEntity);

}
