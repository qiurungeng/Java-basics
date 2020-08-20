package study.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 拒绝策略：
 * AbortPolicy():抛出拒绝异常：java.util.concurrent.RejectedExecutionException
 * CallerRunsPolicy()：回退到调用该线程的线程：main
 * DiscardOldestPolicy()：抛弃阻塞队列的队头
 * DiscardPolicy():抛弃被拒绝任务
 *
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());
        try{
            for (int i = 0; i < 10; i++) {
                threadPoolExecutor.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t办理业务");
                });
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            threadPoolExecutor.shutdown();
        }



    }
}
