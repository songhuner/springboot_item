package com.hang.springbootdemon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.hang.springbootdemon.mapper")
@SpringBootApplication
public class SpringbootItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootItemApplication.class, args);
    }

}
