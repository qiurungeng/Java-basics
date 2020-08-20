package com.study.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class Cat implements InitializingBean, DisposableBean {
    public Cat(){
        System.out.println("cat constructor...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("cat:destroy...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat:after properties set...");
    }
}
