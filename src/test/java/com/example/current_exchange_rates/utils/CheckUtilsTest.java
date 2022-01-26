package com.example.current_exchange_rates.utils;

import com.example.current_exchange_rates.entity.enums.CodeCurrency;
import com.example.current_exchange_rates.exceptions.IllegalArgumentException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ActiveProfiles("actual_course")
public class CheckUtilsTest {

    @Test
    public void checkDirectionTestAsc() {
        assertEquals(Sort.Direction.ASC, CheckUtils.checkDirection("asc"));
    }

    @Test
    public void checkDirectionTestDesc() {
        assertEquals(Sort.Direction.DESC, CheckUtils.checkDirection("ainsc"));
    }

    @Test
    public void checkSortWordTestTest() {
        assertEquals("baseCode", CheckUtils.checkSortWord("baseCode"));
    }

    @Test
    public void checkSortWordTestTestException() {
        IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class,
                () -> CheckUtils.checkSortWord("base"));
        assertEquals("Error enter sort word", throwable.getMessage());
    }

    @Test
    public void checkDirectionTestUsd() {
        String exp = (CheckUtils.checkCode("usd").getCode());
        String act = CodeCurrency.EUR.getCode();
        assertEquals(exp, act);
    }

    @Test
    public void checkDirectionTestEur() {
        String exp = (CheckUtils.checkCode("eur").getCode());
        String act = CodeCurrency.USD.getCode();
        assertEquals(exp, act);
    }

    @Test
    public void checkDirectionTestException() {
        IllegalArgumentException throwable = assertThrows(IllegalArgumentException.class,
                () -> CheckUtils.checkCode("asdasd"));
        assertEquals("Error enter currency", throwable.getMessage());
    }

}