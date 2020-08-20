package com.study;

import com.study.bean.Person;
import com.study.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = context.getBean("person", Person.class);
        System.out.println(person);
        Person person2 = context.getBean("person2", Person.class);
        System.out.println(person2);
        String[] beanNamesForType = context.getBeanNamesForType(Person.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
        System.out.println("_____________");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
