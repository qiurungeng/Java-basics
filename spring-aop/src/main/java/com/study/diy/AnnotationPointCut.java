package com.study.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect //标注这是一个切面
public class AnnotationPointCut {
//    @Before("execution(* com.study.service.UserServiceImpl.*(..))")
//    public void before(){
//        System.out.println("-------------（注解切面）方法执行前--------------");
//    }
//
//    @After("execution(* com.study.service.UserServiceImpl.*(..))")
//    public void after(){
//        System.out.println("-------------（注解切面）方法执行后--------------");
//    }

    @Around("execution(* com.study.service.UserServiceImpl.*(..))")
    public Object around(ProceedingJoinPoint jp) throws Throwable{
        System.out.println("-------------（注解切面）环绕前--------------");
        Signature signature = jp.getSignature();
        System.out.println("signature："+signature);
        Object proceed = jp.proceed();
        System.out.println("-------------（注解切面）环绕后--------------");
        System.out.println(proceed);

        return proceed+"(aop)";
    }
}
