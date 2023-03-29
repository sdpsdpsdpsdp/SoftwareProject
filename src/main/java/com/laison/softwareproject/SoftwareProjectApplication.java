package com.laison.softwareproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.laison.softwareproject.dao")//用通用mapper的scan扫描 s
public class SoftwareProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoftwareProjectApplication.class, args);
    }

}
