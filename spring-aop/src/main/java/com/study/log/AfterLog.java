package com.study.log;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class AfterLog implements AfterReturningAdvice {
    /**
     *
     * @param o 返回值
     * @param method 要执行的目标对象的方法
     * @param objects 方法参数
     * @param o1 目标对象
     */
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("执行了"+method.getName()+"方法，返回了结果："+o);
    }
}
