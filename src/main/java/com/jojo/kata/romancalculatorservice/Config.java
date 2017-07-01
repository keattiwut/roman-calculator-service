package com.jojo.kata.romancalculatorservice;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by kkosittaruk on 30/06/2017.
 */
@Configuration
@Getter
@Setter
@ConfigurationProperties(prefix = "application.file")
public class Config {

    private String input;

    private String output;
}
