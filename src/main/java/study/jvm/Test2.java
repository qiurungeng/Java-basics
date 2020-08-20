package study.jvm;

import java.util.Random;

public class Test2 {
    public static void main(String[] args){
//        printMemoryArgs();

        //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space:

//        StringBuilder str= new StringBuilder("Make A Big NEWS!");
//        while (true) str.append(new Random().nextInt(88888888) + new Random().nextInt(999999999));

        byte[] bytes=new byte[40*1024*1024];
    }

    private static void printMemoryArgs() {
        long maxMemory = Runtime.getRuntime().maxMemory() ;//返回 Java 虚拟机试图使用的最大内存量。
        long totalMemory = Runtime.getRuntime().totalMemory() ;//返回 Java 虚拟机中的内存总量。
        //默认
        //MAX_MEMORY = 3786407936（字节）、3611.0MB  1/4总内存
        //TOTAL_MEMORY = 255328256（字节）、243.5MB  1/64总内存
        System.out.println("MAX_MEMORY = " + maxMemory + "（字节）、" + (maxMemory / (double)1024 / 1024) + "MB");
        System.out.println("TOTAL_MEMORY = " + totalMemory + "（字节）、" + (totalMemory / (double)1024 / 1024) + "MB");
    }

    /**
     * 制造OutOfMemory
     */
    private static void makeOOM(){
        StringBuilder str= new StringBuilder("Make A Big NEWS!");
        while (true) str.append(new Random().nextInt(88888888) + new Random().nextInt(999999999));
    }


}
