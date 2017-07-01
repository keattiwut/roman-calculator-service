package com.jojo.kata.romancalculatorservice.services;

import java.util.List;

/**
 * Created by kkosittaruk on 01/07/2017.
 */
@FunctionalInterface
public interface CalculatorService {
    List<String> calculate(List<String> input);
}
