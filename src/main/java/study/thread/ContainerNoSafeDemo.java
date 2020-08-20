package study.thread;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ContainerNoSafeDemo {
/**
 * 集合类线程不安全问题：ArrayList
 * 1.故障现象
 *  java.util.ConcurrentModificationException
 * 2.导致原因
 *    并发争抢修改导致
 * 3.解决方案
 *  3.1 new Vector<>()
 *  3.2 Collections.synchronizedList(new ArrayList<>());
 *  3.3 new CopyOnWriteArrayList<>();
 *
 *
 * 4.优化建议
 */
    public static void main(String[] args) {
        arrayListNoSafe();


    }

    private static void setNoSafe(){
        Set<String> list=new CopyOnWriteArraySet<>();
//        Set<String> set=Collections.synchronizedSet(new HashSet<>());

        //java.util.ConcurrentModificationException
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }

    private static void arrayListNoSafe() {
        //        List<String> list=new ArrayList<>();
//        List<String> list=new Vector<>();
//        List<String> list= Collections.synchronizedList(new ArrayList<>());
        List<String> list=new CopyOnWriteArrayList<>();

        //java.util.ConcurrentModificationException
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
//        for (int i = 0; i < 10; i++) {
//            list.add(UUID.randomUUID().toString().substring(0,8));
//        }
//
//        for (int i = 0; i < 50; i++) {
//            new Thread(() -> {
//                for (int j = 0; j < list.size(); j++) {
//                    System.out.println(list.get(j));
//                }
//            }).start();
//        }

//        for (int i = 0; i < 50; i++) {
//            new Thread(() -> {
//                for (String s : list) {
//                    System.out.println(s);
//                }
//            }).start();
//        }
    }
}
