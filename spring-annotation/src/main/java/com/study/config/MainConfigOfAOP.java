package com.study.config;

import com.study.aop.LogAspect;
import com.study.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class MainConfigOfAOP {
    @Bean
    public MathCalculator mathCalculator(){
        return new MathCalculator();
    }
    @Bean
    public LogAspect logAspect(){
        return new LogAspect();
    }
}
