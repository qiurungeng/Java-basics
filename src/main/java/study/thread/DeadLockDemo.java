package study.thread;

import java.util.concurrent.TimeUnit;

/**
 * 写一个死锁
 * 核心：两或多个线程执行时因争夺资源造成互相等待的现象，无外力干涉就将一直等下去
 * A有锁A，想要锁B，拿到B才能交出A
 * B有锁B，想要锁A，拿到A才能交出B
 */
class HoldThread implements Runnable{
    private String holdLock;
    private String goalLock;
    public HoldThread(String holdLock,String goalLock) {
        this.holdLock=holdLock;
        this.goalLock = goalLock;
    }
    @Override
    public void run() {
        synchronized (holdLock){
            System.out.println(Thread.currentThread().getName()+"\t 自己持有锁:"+holdLock+
                    "，想要持有锁:"+ goalLock);
            try {
                TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
            synchronized (goalLock){
                System.out.println(Thread.currentThread().getName()+"\t 拿到了锁:"+goalLock);
            }
        }
    }
}
public class DeadLockDemo {
    public static void main(String[] args) {
        String a="A";
        String b="B";
        new Thread(new HoldThread(a,b),"Thread-A").start();
        new Thread(new HoldThread(b,a),"Thread-B").start();
    }
}
