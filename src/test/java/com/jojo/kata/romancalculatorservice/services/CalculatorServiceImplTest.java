package com.jojo.kata.romancalculatorservice.services;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by kkosittaruk on 01/07/2017.
 */
public class CalculatorServiceImplTest {

    @InjectMocks
    CalculatorServiceImpl calculatorService;

    @Mock
    RomanConverterService romanConverterService;

    @Mock
    ExpressionExtractService expressionExtractService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {
        calculatorService = null;
    }

    @Test
    public void calculate_withXXplusIV_shouldReturnXXIV() throws Exception {
        when(expressionExtractService.extractExpression(anyString())).thenReturn(mockExpression());
        when(romanConverterService.toNumerical(anyString(), anyString())).thenReturn(new Integer[]{20, 4});
        when(romanConverterService.toRoman(anyInt())).thenReturn("XXIV");
        List<String> result = calculatorService.calculate(Arrays.asList("XX+IV"));
        assertEquals("XX+IV = XXIV", result.stream().findFirst().get());
    }

    private Object[] mockExpression() {
        return new Object[]{"XX", "IV", Operator.ADD};
    }
}