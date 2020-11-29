package com.hang.springbootdemon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.hang.springbootdemon.mapper")//扫描mapper接口
@SpringBootApplication
public class SpringbootItemApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootItemApp.class, args);
    }

}
