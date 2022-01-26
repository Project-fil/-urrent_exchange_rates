package com.example.current_exchange_rates.utils;

import com.example.current_exchange_rates.entity.enums.CodeCurrency;
import com.example.current_exchange_rates.exceptions.IllegalArgumentException;
import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class CheckUtils {

    private static List<String> fields = new ArrayList<>() {{
        add("id");
        add("apiKey");
        add("lastUpdateCourse");
        add("baseCode");
        add("codeCurrency");
        add("usd");
        add("eur");
        add("lastModifiedDate");
    }};

    public static Sort.Direction checkDirection(String direction) {
        if (direction.equalsIgnoreCase("asc")) {
            return Sort.Direction.ASC;
        }
        return Sort.Direction.DESC;
    }

    public static String checkSortWord(String sortWord) {
        if (!fields.contains(sortWord)) {
            throw new IllegalArgumentException("Error enter sort word");
        }
        return sortWord;
    }


    public static CodeCurrency checkCode(String code) {
        if (code.equalsIgnoreCase(CodeCurrency.USD.getCode())) {
            return CodeCurrency.EUR;
        } else if(code.equalsIgnoreCase(CodeCurrency.EUR.getCode())) {
            return CodeCurrency.USD;
        } else {
            throw new IllegalArgumentException("Error enter currency");
        }
    }

}
