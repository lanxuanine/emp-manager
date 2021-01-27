package com.emsby.empmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.emsby.empmanager.mapper")
public class EmpManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmpManagerApplication.class, args);
    }

}
