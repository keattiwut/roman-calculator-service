package com.jojo.kata.romancalculatorservice;

import com.jojo.kata.romancalculatorservice.services.RomanConverterService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by kkosittaruk on 30/06/2017.
 */
public class RomanConverterServiceTest {

    private RomanConverterService romanConverterService;

    @Before
    public void setup() {
        romanConverterService = new RomanConverterService();
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
    public void toNumerical_withXXIV_shouldReturn9() {
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
}
