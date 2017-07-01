package com.jojo.kata.romancalculatorservice.services;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

/**
 * Created by kkosittaruk on 29/06/2017.
 */
@Service
@Slf4j
public class FileService {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    public List<String> getInput(String path) {
        log.info(String.format("Read input file path %s", path));
        try {
            return FileUtils.readLines(new File(path), StandardCharsets.UTF_8.toString());
        } catch (IOException e) {
            log.error(String.format("Cannot get input : %s", path), e);
        }
        return Collections.emptyList();
    }

    public void writeResult(String path, List<String> result) {
        log.info(String.format("writing output file to path %s", path));
        StringBuilder sb = new StringBuilder();
        for (String line : result) {
            sb.append(line).append(LINE_SEPARATOR);
        }
        try {
            FileUtils.writeStringToFile(new File(path), sb.toString(), StandardCharsets.UTF_8.toString());
        } catch (IOException e) {
            log.error("Cannot write output file", e);
        }
    }
}
