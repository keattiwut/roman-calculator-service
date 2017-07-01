package com.jojo.kata.romancalculatorservice.exception;

/**
 * Created by kkosittaruk on 29/06/2017.
 */
public class ExpressionExtractException extends RuntimeException {

    private static final String ERROR_MESSAGE = "input data mismatch pattern (X)(Operator)(Y)";

    public ExpressionExtractException() {
        super(ERROR_MESSAGE);
    }
}
