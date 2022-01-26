package com.example.current_exchange_rates.services.impl;

import com.example.current_exchange_rates.entity.CourseEntity;
import com.example.current_exchange_rates.services.CourseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;

import static com.example.current_exchange_rates.mocks.CourseEntityMock.defaultCourseEur;
import static com.example.current_exchange_rates.mocks.CourseEntityMock.defaultCourseUsd;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("actual_course")
public class CourseServiceImplTest {

    @Autowired
    private CourseService courseService;

    @Test
    @Sql(value = {"schema.sql", "data.sql"})
    public void getAllTestDesk() {
        List<CourseEntity> exp = new ArrayList<>() {{
            add(defaultCourseEur);
            add(defaultCourseUsd);
        }};
        List<CourseEntity> act = this.courseService.getAllHistory(Sort.by(Sort.Direction.DESC, "usd"));
        assertEquals(exp,act);
    }

    @Test
    @Sql(value = {"schema.sql", "data.sql"})
    public void getAllTestAsk() {
        List<CourseEntity> exp = new ArrayList<>() {{
            add(defaultCourseUsd);
            add(defaultCourseEur);
        }};
        List<CourseEntity> act = this.courseService.getAllHistory(Sort.by(Sort.Direction.ASC, "usd"));
        assertEquals(exp,act);
    }

    @Test
    @Sql(value = {"schema.sql", "data.sql"})
    public void createTest() {

    }

}