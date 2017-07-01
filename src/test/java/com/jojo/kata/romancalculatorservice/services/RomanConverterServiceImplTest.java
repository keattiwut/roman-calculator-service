package com.jojo.kata.romancalculatorservice.services;

import com.jojo.kata.romancalculatorservice.services.RomanConverterServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by kkosittaruk on 30/06/2017.
 */
public class RomanConverterServiceImplTest {

    private RomanConverterServiceImpl romanConverterService;

    @Before
    public void setup() {
        romanConverterService = new RomanConverterServiceImpl();
    }

    @Test
    public void toNumerical_withXX_shouldReturn20() {
        int result = romanConverterService.toNumerical("XX");
        Assert.assertEquals(20, result);
    }

    @Test
    public void toNumerical_withIX_shouldReturn9() {
        int result = romanConverterService.toNumerical("IX");
        Assert.assertEquals(9, result);
    }

    @Test
    public void toNumerical_withXXIV_shouldReturn24() {
        int result = romanConverterService.toNumerical("XXIV");
        Assert.assertEquals(24, result);
    }

    @Test
    public void toRoman_with4_shouldReturnIV() {
        String result = romanConverterService.toRoman(4);
        Assert.assertEquals("IV", result);
    }

    @Test
    public void toRoman_roman9_shouldReturnIX() {
        String result = romanConverterService.toRoman(9);
        Assert.assertEquals("IX", result);
    }

    @Test
    public void toNumerical_withIVAndIX_shouldReturn4and9() {
        Integer[] result = romanConverterService.toNumerical("IV", "IX");
        Assert.assertTrue(result[0] == 4 && result[1] == 9);
    }
}
