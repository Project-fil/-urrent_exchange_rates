package com.example.current_exchange_rates.utils;

import com.example.current_exchange_rates.entity.enums.CodeCurrency;
import com.example.current_exchange_rates.exceptions.IllegalArgumentException;
import com.example.current_exchange_rates.exceptions.KeyNotValidException;
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

    public static String checkCompany(String apiKey) {
        if (apiKey.equals("6933516f73f2016658690a3a")) {
            return "ExchangeRate-API";
        } else if(apiKey.equals("5c4bc070-797b-11ec-9d8f-ade5adf8122c")) {
            return "Free Currency API";
        } else {
            throw new KeyNotValidException("Key not valid");
        }
    }

}
