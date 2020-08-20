package com.study.cyclicDependency;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class CDConfig {
    @Bean
    public A a(){
        return new A();
    }

    @Bean
    public B b(){
        return new B();
    }
}
