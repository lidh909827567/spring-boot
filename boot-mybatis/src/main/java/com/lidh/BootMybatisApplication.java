package com.lidh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author
 */
@SpringBootApplication
@MapperScan("com.lidh.mapper")
public class BootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootMybatisApplication.class, args);
    }
}
