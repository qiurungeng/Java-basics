package com.study.test;

import com.study.aop.MathCalculator;
import com.study.config.MainConfigOfAOP;
import com.study.config.MainConfigOfProfile;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class IOCTest_AOP {
    @Test
    public void test1(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
        MathCalculator mathCalculator = context.getBean(MathCalculator.class);
        System.out.println(mathCalculator.div(1,1));
        context.close();
    }
}
