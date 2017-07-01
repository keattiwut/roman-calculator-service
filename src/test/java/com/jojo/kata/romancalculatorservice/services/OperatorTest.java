package com.jojo.kata.romancalculatorservice.services;

import com.jojo.kata.romancalculatorservice.exception.OperatorIllegalException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kkosittaruk on 01/07/2017.
 */
public class OperatorTest {

    @Test
    public void apply_Add_returnAddResult() throws Exception {
        int result = Operator.ADD.apply(1, 1);
        assertEquals(2, result);
    }

    @Test
    public void apply_Minus_returnMinusResult() throws Exception {
        int result = Operator.MINUS.apply(10, 2);
        assertEquals(8, result);
    }

    @Test
    public void apply_Multiply_returnMultiplyResult() throws Exception {
        int result = Operator.MULTIPLY.apply(2, 2);
        assertEquals(4, result);
    }

    @Test
    public void apply_Divide_returnDivideResult() throws Exception {
        int result = Operator.DIVIDE.apply(10, 2);
        assertEquals(5, result);
    }

    @Test
    public void parse_withAddOperatorString_returnAddOperatorEnum() throws Exception {
        Operator result = Operator.parse("+");
        assertEquals(Operator.ADD, result);
    }

    @Test
    public void parse_withMinusOperatorString_returnMinusOperatorEnum() throws Exception {
        Operator result = Operator.parse("-");
        assertEquals(Operator.MINUS, result);
    }

    @Test
    public void parse_withMultiplyOperatorString_returnMultiplyOperatorEnum() throws Exception {
        Operator result = Operator.parse("*");
        assertEquals(Operator.MULTIPLY, result);
    }

    @Test
    public void parse_withDivideOperatorString_returnDivideOperatorEnum() throws Exception {
        Operator result = Operator.parse("/");
        assertEquals(Operator.DIVIDE, result);
    }

    @Test(expected = OperatorIllegalException.class)
    public void parse_withIncorrectOperatorString_throwOperationIllegalException() throws Exception {
        Operator.parse("@");
    }

}