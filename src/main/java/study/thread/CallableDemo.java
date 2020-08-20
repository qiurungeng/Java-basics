package study.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+" come in callable");
        return 1024;
    }
}
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThread myThread=new MyThread();
        FutureTask<Integer> futureTask=new FutureTask<>(myThread);
        new Thread(futureTask,"AA").start();
        Integer result = futureTask.get();
        System.out.println("get result of future task:"+result);
    }
}
