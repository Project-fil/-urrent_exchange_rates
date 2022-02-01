package com.example.current_exchange_rates.services.impl;

import com.example.current_exchange_rates.entity.CourseEntity;
import com.example.current_exchange_rates.services.CourseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.example.current_exchange_rates.mocks.CourseEntityMock.defaultCourseEur;
import static com.example.current_exchange_rates.mocks.CourseEntityMock.defaultCourseUsd;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        assertEquals(exp, act);
    }

    @Test
    @Sql(value = {"schema.sql", "data.sql"})
    public void getAllTestAsk() {
        List<CourseEntity> exp = new ArrayList<>() {{
            add(defaultCourseUsd);
            add(defaultCourseEur);
        }};
        List<CourseEntity> act = this.courseService.getAllHistory(Sort.by(Sort.Direction.ASC, "usd"));
        assertEquals(exp, act);
    }

    @Test
    @Sql(value = {"schema.sql", "data.sql"})
    public void getByIdTest() {
        CourseEntity act = this.courseService.getById(defaultCourseEur.getId());
        assertEquals(defaultCourseEur, act);
    }

    @Test
    @Sql(value = {"schema.sql", "data.sql"})
    public void getByIdTestException() {
        assertThrows(IllegalArgumentException.class, () -> this.courseService.getById(UUID.fromString("null")));
    }

    @Test
    @Sql(value = {"schema.sql", "data.sql"})
    public void getByIdTestExceptionNull() {
        assertThrows(InvalidDataAccessApiUsageException.class, () -> this.courseService.getById(null));
    }

    @Test
    @Sql(value = {"schema.sql"})
    public void createTest() {
        CourseEntity exp = this.courseService.create(defaultCourseUsd);
        CourseEntity act = this.courseService.getById(defaultCourseUsd.getId());
        assertEquals(exp, act);
    }

    @Test
    @Sql(value = {"schema.sql", "data.sql"})
    public void createTestExceptionNull() {
        assertThrows(InvalidDataAccessApiUsageException.class, () -> this.courseService.create(null));
    }

}