package com.jojo.kata.romancalculatorservice;

import com.jojo.kata.romancalculatorservice.services.CalculatorService;
import com.jojo.kata.romancalculatorservice.services.FileServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by kkosittaruk on 01/07/2017.
 */
@Component
@Slf4j
public class ApplicationStart implements CommandLineRunner {

    private final FileServiceImpl fileService;

    private final CalculatorService calculatorService;

    private final Config config;

    @Autowired
    public ApplicationStart(FileServiceImpl fileService, CalculatorService calculatorService, Config config) {
        this.fileService = fileService;
        this.calculatorService = calculatorService;
        this.config = config;
    }

    @Override
    public void run(String... strings) throws Exception {
        log.info("Starting processing...");
        List<String> input = fileService.getInput(config.getInput());
        List<String> result = calculatorService.calculate(input);
        fileService.writeResult(config.getOutput(), result);
        log.info("Ending processing...");
    }
}
