package com.jojo.kata.romancalculatorservice.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kkosittaruk on 29/06/2017.
 */
@Service
@Slf4j
public class CalculatorServiceImpl implements CalculatorService {

    private final RomanConverterService romanConverterService;

    private final ExpressionExtractService expressionExtractService;

    @Autowired
    public CalculatorServiceImpl(RomanConverterService romanConverterService,
                                 ExpressionExtractService expressionExtractService) {
        this.romanConverterService = romanConverterService;
        this.expressionExtractService = expressionExtractService;
    }

    @Override
    public List<String> calculate(List<String> input) {
        List<String> result = new ArrayList<>();
        input.forEach(data -> {
            try {
                log.info(String.format("expression : %s", data));
                Object[] expression = expressionExtract(data);
                Operator operator = (Operator) expression[2];
                Integer[] numbers = toNumerical(expression);
                Integer sum = compute(numbers[0], numbers[1], operator);
                String line = buildLineResult(data, sum);
                result.add(line);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                throw e;
            }
        });
        return result;
    }

    private Integer[] toNumerical(Object[] expression) {
        return romanConverterService.toNumerical((String) expression[0], (String) expression[1]);
    }

    private Object[] expressionExtract(String data) {
        return expressionExtractService.extractExpression(data);
    }

    private String buildLineResult(String lineInput, Integer sum) {
        String romanSum = romanConverterService.toRoman(sum);
        return String.format("%s = %s", lineInput, romanSum);
    }

    private Integer compute(Integer x, Integer y, Operator operator) {
        return operator.apply(x, y);
    }
}
