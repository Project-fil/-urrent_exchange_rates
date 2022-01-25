package com.example.current_exchange_rates.repositories;

import com.example.current_exchange_rates.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity, String> {
}
