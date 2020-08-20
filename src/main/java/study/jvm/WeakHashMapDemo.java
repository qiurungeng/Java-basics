package study.jvm;

import java.util.WeakHashMap;

public class WeakHashMapDemo {
    public static void main(String[] args) {
        WeakHashMap<Integer,String> weakHashMap=new WeakHashMap<>();
        WeakHashMap<Integer, Integer> intMap = new WeakHashMap<>();
        Integer key=new Integer(2);
        String value="asd";

        weakHashMap.put(key,value);
        weakHashMap.put(3,value);   //int的话不会被GC？
        intMap.put(55,66);
        Integer a=new Integer(77);Integer b=new Integer(88);
        intMap.put(a,b);
        intMap.put(new Integer(99),1010);
        intMap.put(1111,new Integer(1212));
        System.out.println(weakHashMap+intMap.toString());

        key=null;
        System.out.println(weakHashMap+intMap.toString());

        System.gc();
        System.out.println(weakHashMap+intMap.toString());
        System.out.println(a+":"+b);
    }
}
