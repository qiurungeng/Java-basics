package study.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock优势：
 * 可通过Condition来分组唤醒需要唤醒的线程，实现精确唤醒。
 * 例：
 * （A线程打印5次，B线程打印10次，C线程打印15次）将这组操作执行3轮
 */
class ShareResource{
    private int number=1;
    private Lock lock=new ReentrantLock();
    private Condition c1=lock.newCondition();
    private Condition c2=lock.newCondition();
    private Condition c3=lock.newCondition();
    void print5times(){
        lock.lock();
        try {
            while (number!=1)c1.await();
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            number=2;
            c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    void print10times(){
        lock.lock();
        try {
            while (number!=2)c2.await();
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            number=3;
            c3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    void print15times(){
        lock.lock();
        try {
            while (number!=3)c3.await();
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i);
            }
            number=1;
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
public class SyncAndReentrantLockDemo {
    public static void main(String[] args) {
        ShareResource shareResource=new ShareResource();
        new Thread(()->{for(int i=0;i<3;i++) {shareResource.print5times();}},"A").start();
        new Thread(()->{for(int i=0;i<3;i++) {shareResource.print10times();}},"B").start();
        new Thread(()->{for(int i=0;i<3;i++) {shareResource.print15times();}},"C").start();
    }
}
