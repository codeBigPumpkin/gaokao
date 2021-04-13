package com.ceev.wcee;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.ceev.wcee.mapper")
@EnableScheduling
public class GaokaoApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(GaokaoApplication.class, args);
    }

}
