package com.github.lucx.tvmovietracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class TvmovietrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TvmovietrackerApplication.class, args);
    }

}
