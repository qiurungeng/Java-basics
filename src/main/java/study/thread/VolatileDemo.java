package study.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyData{
    volatile int number=0;
    void addTo60(){
        this.number=60;
    }

    //此时加了volatile关键字，但也不能保证原子性
    void addPlusPlus(){
        this.number++;
    }

    AtomicInteger atomicInteger=new AtomicInteger();

    void addMyAtomic(){
        atomicInteger.getAndIncrement();
    }
}

/**
 * 1. 验证volatile的可见性
 *    假如int number=0；number变量之前根本没有添加volatile关键字修饰
 * 2. 验证volatile不保证原子性
 *    原子性：不可分割、完整性。线程正在做某个具体业务时，中间不可被加塞或分割，要么同时成功要么同时失败
 *    为什么不能保证？多个线程并发写时，还没来得及获得主物理内存中值的最新变化，就进行了写覆盖
 *    如何保证原子性？
 *          加sync（杀鸡用牛刀）
 *          使用juc下的atomicInteger
 *
 */
public class VolatileDemo {

    /**
     * 可见性测试
     * volatile保证可见性，能及时通知其他线程，主物理内存的变量已经被修改
     */
    private static void visibility(){
        MyData data=new MyData();   //资源类

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t comes in");
            //暂停一下线程
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
            data.addTo60();
            System.out.println(Thread.currentThread().getName()+"\t update number to:"+data.number);
        },"AAA").start();

        //第二个线程为main线程
        while (data.number==0){

        }
        /*
         * 若不加volatile，不具备可见性，main线程永远无法获得AAA线程变更值的通知，工作内存中的值没变更，永远无法抵达这里
         * 若加volatile，具备可见性，number变更后将执行该语句
         */
        System.out.println(Thread.currentThread().getName()+"\t mission is over,main get number value:"+data.number);
    }

    /**
     * 不保证原子性测试：
     *
     */
    private static void atomicity(){
        MyData myData=new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    myData.addPlusPlus();
                    myData.addMyAtomic();
                }
            },String.valueOf(i)).start();
        }

        //需要等待上面20个线程都计算完后，用main线程取得最终的结果值
        while (Thread.activeCount()>2){
            Thread.yield();
        }

        //main	 finally number value:19907+-，时而不符合预期值：20000
        System.out.println(Thread.currentThread().getName()+"\tfinally number value:"+myData.number);
        //main	Atomic type, finally number value:20000, 可保证原子性
        System.out.println(Thread.currentThread().getName()+"\tAtomic type, finally number value:"+myData.atomicInteger);
    }


    public static void main(String[] args) {
//        visibility();
        atomicity();
    }
}
