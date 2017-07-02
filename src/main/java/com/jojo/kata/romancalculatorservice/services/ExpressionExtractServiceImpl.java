package com.jojo.kata.romancalculatorservice.services;

import com.jojo.kata.romancalculatorservice.exception.ExpressionExtractException;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ExpressionExtractServiceImpl implements ExpressionExtractService {

    private static final String EXPRESSION_PATTERN = "(?<x>\\w*)(?<operator>\\W)(?<y>\\w*)";

    private final Pattern expressionPattern = Pattern.compile(EXPRESSION_PATTERN);

    @Override
    public Object[] extractExpression(String data) {
        Matcher m = expressionPattern.matcher(data);
        if (!m.find()) {
            throw new ExpressionExtractException();
        }
        String x = m.group("x");
        String y = m.group("y");
        String operator = m.group("operator");
        return new Object[]{x, y, Operator.parse(operator)};
    }
}