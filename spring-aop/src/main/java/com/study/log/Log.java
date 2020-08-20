package com.study.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Log implements MethodBeforeAdvice {

    /**
     *
     * @param method 要执行的目标对象的方法
     * @param objects 方法参数
     * @param o 目标对象
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        ReentrantReadWriteLock readLock = new ReentrantReadWriteLock();
        readLock.readLock();
        System.out.println(o.getClass().getName()+"的"+method.getName()+"方法被执行了");
    }
}
