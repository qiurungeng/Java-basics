package com.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class Test1 {

    @Autowired
    Test2 test2;

    @Transactional
    public void test(){
        System.out.println("now in test1, I will call test 2");
        test2.test(0);
    }
}
