package com.tayfurunal.tddspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class TddspringApplication {

    public static void main(String[] args) {
        SpringApplication.run(TddspringApplication.class, args);
    }

}
