package spring.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.bean.BeanA;
import spring.config.AppConfig;

public class ConfigTest {
    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        BeanA beanA = context.getBean("getBeanA",BeanA.class);
        BeanA beanAA = context.getBean("getBeanA",BeanA.class);
        System.out.println(beanA.toString());
        System.out.println(beanA==beanAA);
    }
}
