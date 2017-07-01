package com.jojo.kata.romancalculatorservice.services;

import com.jojo.kata.romancalculatorservice.exception.ExpressionExtractException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kkosittaruk on 29/06/2017.
 */
@Service
@Slf4j
public class CalculatorService {

    private static final String EXPRESSION_PATTERN = "(?<x>\\w*)(?<operator>\\W)(?<y>\\w*)";

    private final Pattern expressionPattern = Pattern.compile(EXPRESSION_PATTERN);

    private final RomanConverterService romanConverterService;

    @Autowired
    public CalculatorService(RomanConverterService romanConverterService) {
        this.romanConverterService = romanConverterService;
    }

    public List<String> calculate(List<String> input) {
        List<String> result = new ArrayList<>();
        input.forEach(data -> {
            try {
                log.info(String.format("expression : %s", data));
                Object[] expression = extractExpression(data);
                Operator operator = (Operator) expression[2];
                Integer[] numbers = romanConverterService.toNumerical((String)expression[0], (String)expression[1]);
                Integer sum = compute(numbers[0], numbers[1], operator);
                String line = buildLineResult(data, sum);
                result.add(line);
            }catch (Exception e) {
                log.error(e.getMessage(), e);
                throw e;
            }
        });
        return result;
    }

    private Object[] extractExpression(String data) {
        Matcher m = expressionPattern.matcher(data);
        if (!m.find()) {
            throw new ExpressionExtractException();
        }
        String x = m.group("x");
        String y = m.group("y");
        String operator = m.group("operator");
        return new Object[]{x, y, Operator.parse(operator)};
    }

    private String buildLineResult(String lineInput, Integer sum) {
        String romanSum = romanConverterService.toRoman(sum);
        return String.format("%s = %s", lineInput, romanSum);
    }

    private Integer compute(Integer x, Integer y, Operator operator) {
        return operator.apply(x, y);
    }
}
