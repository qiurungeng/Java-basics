package com.study.bean;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Dog implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    public Dog(){
        System.out.println("dog constructor...");
    }

    //对象创建并赋值之后调用
    @PostConstruct
    public void init(){
        System.out.println("dog @PostConstruct...");
    }

    //容器销毁对象之前调用
    @PreDestroy
    public void destroy(){
        System.out.println("dog @PreDestroy...");
    }

    /**
     * 组件通过这个方法能得到IOC容器，将对其依赖保存起来，以后可以用到
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}
