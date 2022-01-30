package com.example.current_exchange_rates.services.impl;

import com.example.current_exchange_rates.services.TemplateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("actual_course")
class TemplateServiceImplTest {

    @Autowired
    private TemplateService templateService;

    @Test
    public void getInfoAnotherServiceTest() {

    }

}