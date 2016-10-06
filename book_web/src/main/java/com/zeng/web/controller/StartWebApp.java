package com.zeng.web.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Administrator on 2016/9/30.
 */
@SpringBootApplication
@ComponentScan({"com.fc","com.zeng.web.controller","com.zeng.web.service"})
@MapperScan("com.zeng.dao.mapper")
public class StartWebApp extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(StartWebApp.class, args);//启动Spring Boot框架
    }
}
