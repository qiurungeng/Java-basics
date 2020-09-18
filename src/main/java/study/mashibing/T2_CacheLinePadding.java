package study.mashibing;

import java.util.concurrent.CountDownLatch;

public class T2_CacheLinePadding {
    public static long COUNT = 1_0000_0000L;
    public static T[] arr = new T[2];

    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        Thread t1 = new Thread(() -> {
            //修改1亿次
            for (int i = 0; i < COUNT; i++) {
                arr[0].x = i;
            }

            latch.countDown();
        });
        Thread t2 = new Thread(() -> {
            //修改1亿次
            for (int i = 0; i < COUNT+1; i++) {
                arr[1].x = i;
            }

            latch.countDown();
        });

        final long start = System.nanoTime();
        t1.start();
        t2.start();
        latch.await();
        System.out.println((System.nanoTime() - start)/100_0000);    //964
        System.out.println(arr[0].x);
        System.out.println(arr[1].x);
    }

    static class T{
        public long p1,p2,p3,p4,p5,p6,p7;
        public volatile long x = 0L; //long: 8byte
        public long p9,p10,p11,p12,p13,p14,p15;
    }
}
