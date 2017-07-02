package com.jojo.kata.romancalculatorservice.services;

import com.jojo.kata.romancalculatorservice.exception.ExpressionExtractException;
import com.jojo.kata.romancalculatorservice.exception.OperatorIllegalException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by kkosittaruk on 02/07/2017.
 */
public class ExpressionExtractServiceImplTest {

    ExpressionExtractServiceImpl expressionExtractService;

    @Before
    public void setUp() throws Exception {
        expressionExtractService = new ExpressionExtractServiceImpl();
    }

    @After
    public void tearDown() throws Exception {
        expressionExtractService = null;
    }

    @Test
    public void extractExpression() throws Exception {
        Object[] result = expressionExtractService.extractExpression("XX+IV");
        assertTrue(result[0].equals("XX") && result[1].equals("IV") && result[2] == Operator.ADD);
    }

    @Test(expected = OperatorIllegalException.class)
    public void calculate_withSpecialCharacterOperation_shouldThrowOperationIllegalException() {
        expressionExtractService.extractExpression("XX@IV");
    }

    @Test(expected = ExpressionExtractException.class)
    public void calculate_withWrongExpressionPattern_shouldThrowExpressionExtractException() {
        expressionExtractService.extractExpression("XXXIV");
    }
}