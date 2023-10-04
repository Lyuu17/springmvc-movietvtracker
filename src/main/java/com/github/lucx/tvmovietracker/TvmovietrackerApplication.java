package com.github.lucx.tvmovietracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableCaching
@EnableFeignClients
public class TvmovietrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TvmovietrackerApplication.class, args);
    }

}
