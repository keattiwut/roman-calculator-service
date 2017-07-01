package com.jojo.kata.romancalculatorservice;

import com.jojo.kata.romancalculatorservice.services.CalculatorService;
import com.jojo.kata.romancalculatorservice.services.FileServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.*;
import static org.powermock.api.mockito.PowerMockito.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

/**
 * Created by kkosittaruk on 01/07/2017.
 */
public class ApplicationStartTest {

    @InjectMocks
    ApplicationStart applicationStart;

    @Mock
    FileServiceImpl fileService;

    @Mock
    CalculatorService calculatorService;

    @Mock
    Config config;

    @Before
    public void setup() throws IOException {
        MockitoAnnotations.initMocks(this);
        when(config.getInput()).thenReturn("./mock-path");
        when(fileService.getInput(anyString())).thenReturn(new ArrayList<>());
        doNothing().when(fileService).writeResult(anyString(), anyList());
        when(calculatorService.calculate(anyList())).thenReturn(mockResult());
    }

    private List mockResult() {
        return Arrays.asList("XX+XX = Mock Result!");
    }

    @Test
    public void run_withMockService_shouldCallAllDependService() throws Exception {
        applicationStart.run("");
        verify(fileService, times(1)).getInput(anyString());
        verify(fileService, times(1)).writeResult(anyString(), anyList());
        verify(config, times(1)).getInput();
        verify(calculatorService, times(1)).calculate(anyList());
    }

}