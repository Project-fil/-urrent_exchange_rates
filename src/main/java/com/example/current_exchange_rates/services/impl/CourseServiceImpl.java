package com.example.current_exchange_rates.services.impl;

import com.example.current_exchange_rates.entity.CourseEntity;
import com.example.current_exchange_rates.exceptions.EntityNotFoundException;
import com.example.current_exchange_rates.repositories.CourseRepository;
import com.example.current_exchange_rates.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;


    @Override
    public List<CourseEntity> getAllHistory(Sort sort) {
        return this.courseRepository.findAll(sort);
    }

    @Override
    public CourseEntity getById(String id) {
        return this.courseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course not found"));
    }


    @Override
    public CourseEntity create(CourseEntity courseEntity) {
        return this.courseRepository.save(courseEntity);
    }
}
