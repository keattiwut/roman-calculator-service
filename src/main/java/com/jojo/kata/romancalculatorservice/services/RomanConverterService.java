package com.jojo.kata.romancalculatorservice.services;


import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kkosittaruk on 29/06/2017.
 */
@Service
public class RomanConverterService {

    private static final List<Integer> ROMAN_VALUES = Arrays.asList(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);

    private static final List<String> ROMAN_SYMBOLS = Arrays.asList("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I");

    public Integer[] toNumerical(String... romans) {
        List<Integer> numbers = new ArrayList<>();
        for (String roman : romans) {
            int number = toNumerical(roman);
            numbers.add(number);
        }
        return numbers.toArray(new Integer[numbers.size()]);
    }

    public int toNumerical(String roman) {
        if (!StringUtils.hasText(roman)) {
            return 0;
        }

        for (int index = 0; index < ROMAN_SYMBOLS.size(); index++) {
            if (roman.startsWith(ROMAN_SYMBOLS.get(index)))
                return ROMAN_VALUES.get(index) + toNumerical(roman.replaceFirst(ROMAN_SYMBOLS.get(index), ""));
        }
        return 0;
    }

    public String toRoman(final int num) {
        int number = num;
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < ROMAN_VALUES.size(); index++) {
            while (number >= ROMAN_VALUES.get(index)) {
                sb.append(ROMAN_SYMBOLS.get(index));
                number -= ROMAN_VALUES.get(index);
            }
        }
        return sb.toString();
    }

}
