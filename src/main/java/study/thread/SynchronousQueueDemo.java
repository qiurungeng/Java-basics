package study.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 同步队列，不存储
 * 只能生产一个消费一个，
 */
public class SynchronousQueueDemo {


    public static void main(String[] args) {
        BlockingQueue<String> queue= new SynchronousQueue<>(false);
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName()+"\t put 1");
                queue.put("1");
                System.out.println(Thread.currentThread().getName()+"\t put 2");
                queue.put("2");
                System.out.println(Thread.currentThread().getName()+"\t put 3");
                queue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();
        new Thread(() -> {
            try {
                try {TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e) {e.printStackTrace();}
                System.out.println(Thread.currentThread().getName()+"\t"+queue.take());
                try {TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e) {e.printStackTrace();}
                System.out.println(Thread.currentThread().getName()+"\t"+queue.take());
                try {TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e) {e.printStackTrace();}
                System.out.println(Thread.currentThread().getName()+"\t"+queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BBB").start();
    }
}
