package com.study.cyclicDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class B {
    @Autowired
    private A a;
    public void setA(A a) {
        this.a = a;
    }

    public A getA() {
        return a;
    }
}
