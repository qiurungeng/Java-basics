package com.study.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Test1 test1(){
        return new Test1();
    }

    @Bean
    public Test2 test2(){
        return new Test2();
    }
}
