package com.jojo.kata.romancalculatorservice.services;

/**
 * Created by kkosittaruk on 02/07/2017.
 */
@FunctionalInterface
public interface ExpressionExtractService {

    Object[] extractExpression(String data);
}
