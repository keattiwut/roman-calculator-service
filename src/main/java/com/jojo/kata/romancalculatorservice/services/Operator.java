package com.jojo.kata.romancalculatorservice.services;

import com.jojo.kata.romancalculatorservice.exception.OperatorIllegalException;

/**
 * Created by kkosittaruk on 30/06/2017.
 */
public enum Operator {

    ADD("+") {
        @Override
        public int apply(int x, int y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        public int apply(int x, int y) {
            return x - y;
        }
    },
    MULTIPLY("*") {
        @Override
        public int apply(int x, int y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        public int apply(int x, int y) {
            return x / y;
        }
    };

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public abstract int apply(int x, int y);

    @Override
    public String toString() {
        return symbol;
    }

    public static Operator parse(String operator) {
        for (Operator o : Operator.values()) {
            if (o.toString().equals(operator)) {
                return o;
            }
        }
        throw new OperatorIllegalException();
    }
}
