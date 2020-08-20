package com.study.cyclicDependency;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestCD {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CDConfig.class);
        A a = context.getBean("a", A.class);
        System.out.println(a);
        System.out.println(a.getB());
        System.out.println(a.getB().getA()==a);
    }
}
