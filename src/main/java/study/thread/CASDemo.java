package study.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1. CAS是什么
 *      比较并交换
 *
 */
public class CASDemo {



    public static void main(String[] args) {
        AtomicInteger atomicInteger=new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5,2019)+"\t current data:"+atomicInteger.get());
    }
}
