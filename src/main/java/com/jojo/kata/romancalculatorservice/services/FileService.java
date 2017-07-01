package com.jojo.kata.romancalculatorservice.services;

import java.util.List;

/**
 * Created by kkosittaruk on 01/07/2017.
 */
public interface FileService {
    List<String> getInput(String path);

    void writeResult(String path, List<String> result);
}
