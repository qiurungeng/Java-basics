package com.study.test;

import com.study.bean.Person;
import com.study.config.MainConfigOfPropertyValue;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class IOCTest_PropertyValue {
    @Test
    public void test1(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfPropertyValue.class);
        Person person = context.getBean("person", Person.class);
        System.out.println(person);
        ConfigurableEnvironment environment = context.getEnvironment();
        String property = environment.getProperty("person.nickname");
        System.out.println(property);
    }
}
