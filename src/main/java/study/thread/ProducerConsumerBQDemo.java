package study.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyResource{
    private volatile boolean flag=true;
    private AtomicInteger atomicInteger=new AtomicInteger();
    private BlockingQueue<String> blockingQueue=null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName()); //查看BQ接口的具体实现类
    }

    public void myProducer() throws InterruptedException {
        String data=null;
        boolean returnValue;
        while (flag){
            data=atomicInteger.incrementAndGet()+"";
            returnValue=blockingQueue.offer(data,2L,TimeUnit.SECONDS);
            if (returnValue) System.out.println(Thread.currentThread().getName()+"\t插入数据"+data+"成功");
            else System.out.println(Thread.currentThread().getName()+"\t插入数据"+data+"失败");
            try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
        }
        System.out.println(Thread.currentThread().getName()+"\t停止生产");
    }
    public void myConsumer() throws InterruptedException {
        String result=null;
        while (flag){
            result=blockingQueue.poll(2L,TimeUnit.SECONDS);
            if (result==null||"".equalsIgnoreCase(result)){
                flag=false;
                System.out.println("\n");
                System.out.println(Thread.currentThread().getName()+"超过两秒没有产品可消费，退出");
                return;
            }
            System.out.println(Thread.currentThread().getName()+"\t 消费"+result+"成功");
        }
    }
    public void stop(){
        flag=false;
    }
}

public class ProducerConsumerBQDemo {
    public static void main(String[] args) {
        MyResource myResource=new MyResource(new ArrayBlockingQueue<>(10));
        new Thread(() -> {
            try {
                myResource.myProducer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Producer").start();
        new Thread(() -> {
            try {
                myResource.myConsumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"Consumer").start();
        try {TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e) {e.printStackTrace();}
        System.out.println("\n\n\n时间到，命令生产者停止生产");
        myResource.stop();
    }
}
