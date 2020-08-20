package com.study.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 日志切面类
 */
@Aspect
public class LogAspect {
    //抽取公共的切入点表达式
    //1.可供本类引用
    //2.可供其他的切面引用
    @Pointcut("execution(* *com.study.aop.MathCalculator.*(..))")
    public void pointCut(){}

//    @Before("pointCut()")
//    public void logStart(){
//        System.out.println("1111除法运算开始...参数列表为：{}");
//    }

    //加上参数JoinPoint获取运行时方法
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName()+"(除法运算)开始...参数列表为：{"+ Arrays.asList(joinPoint.getArgs())+"}");
    }

    @After("com.study.aop.LogAspect.pointCut()")
    public void logEnd(){
        System.out.println("除法云散结束...");
    }

    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(Object result){
        System.out.println("除法正常返回...运行结果是：{"+result+"}");
    }

    @AfterThrowing(value = "pointCut()",throwing = "e")
    public void logException(Exception e){
        System.out.println("除法抛出异常...异常为"+e.getMessage()+"");
    }
}
