package com.jojo.kata.romancalculatorservice.services;

/**
 * Created by kkosittaruk on 01/07/2017.
 */
public interface RomanConverterService {
    Integer[] toNumerical(String... romans);

    int toNumerical(String roman);

    String toRoman(int num);
}
