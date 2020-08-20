package com.study.test;

import com.study.bean.Person;
import com.study.config.MainConfig2;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IOCTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);

    @Test
    public void test3(){
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);
        String[] persons = context.getBeanNamesForType(Person.class);
        for (String person : persons) {
            System.out.println(person);
        }
    }

    @Test
    public void testImport(){
        String[] names = context.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        Object colorFactoryBean1 = context.getBean("colorFactoryBean");
        Object colorFactoryBean2 = context.getBean("colorFactoryBean");
        System.out.println("colorFactoryBean1的类型："+colorFactoryBean1.getClass());
        System.out.println("colorFactoryBean2的类型："+colorFactoryBean2.getClass());
        System.out.println("两次获取到的bean是否相同："+(colorFactoryBean1==colorFactoryBean2));
        Object bean = context.getBean("&colorFactoryBean");
        System.out.println("bean类型："+bean.getClass());
    }
}
