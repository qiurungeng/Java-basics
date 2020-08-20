package study.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData{
    private int num=0;
    private Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();

    public void increment() throws InterruptedException {
        try{
            lock.lock();
            //等待，不生产
            while (num!=0)condition.await();
            //生产
            num++;
            System.out.println(Thread.currentThread().getName()+"\t"+num);
            //通知，唤醒
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void decrease() throws InterruptedException {
        try{
            lock.lock();
            //等待，不生产
            while (num==0)condition.await();
            //消费
            num--;
            System.out.println(Thread.currentThread().getName()+"\t"+num);
            //通知，唤醒
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
}
/**
 * 一个初始值为0的变量，两个线程对其交替操作，一个加一一个减一，来五轮
 */
public class ProducerConsumerTraditionDemo {
    public static void main(String[] args) {
        ShareData shareData=new ShareData();
        new Thread(() -> {
            for (int i = 1; i < 5; i++) {
                try {
                    shareData.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"AA").start();
        new Thread(() -> {
            for (int i = 1; i < 5; i++) {
                try {
                    shareData.decrease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();
    }
}
