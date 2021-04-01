package com.typemoon.fate;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.typemoon.fate.mapper")
public class FateApplication {

    public static void main(String[] args) {
        SpringApplication.run(FateApplication.class, args);
    }

}
