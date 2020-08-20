package com.study.cyclicDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {
    @Autowired
    private B b;
    public void setB(B b){
        this.b=b;
    }

    public B getB() {
        return b;
    }
}
