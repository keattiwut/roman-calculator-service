package com.jojo.kata.romancalculatorservice.exception;

/**
 * Created by kkosittaruk on 29/06/2017.
 */
public class OperatorIllegalException extends RuntimeException {

    private static final String ERROR_MESSAGE = "Illegal operator";

    public OperatorIllegalException() {
        super(ERROR_MESSAGE);
    }
}
