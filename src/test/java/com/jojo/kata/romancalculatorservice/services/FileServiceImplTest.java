package com.jojo.kata.romancalculatorservice.services;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

/**
 * Created by kkosittaruk on 01/07/2017.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(FileUtils.class)
public class FileServiceImplTest {

    @InjectMocks
    FileServiceImpl fileService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockStatic(FileUtils.class);
    }

    @After
    public void tearDown() throws Exception {
        fileService = null;
    }

    @Test
    public void getInput() throws Exception {
        when(FileUtils.readLines(any(File.class), anyString())).thenReturn(Arrays.asList("XX+IV"));
        List<String> result = fileService.getInput("./input/input.txt");
        assertNotNull(result);
    }

    @Test
    public void getInput_notExitsPath_returnEmptyCollection() throws Exception {
        when(FileUtils.readLines(any(File.class), anyString())).thenThrow(new IOException("path not found"));
        List<String> result = fileService.getInput("./input/input.txt");
        assertTrue(result.isEmpty());
    }

    @Test
    public void writeResult() throws Exception {
        doNothing().when(FileUtils.class);
        List<String> line = Arrays.asList("XX+IV = XXIV");
        fileService.writeResult("./output/output.txt", line);
        PowerMockito.verifyStatic(times(1));
    }
}