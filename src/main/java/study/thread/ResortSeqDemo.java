package study.thread;

public class ResortSeqDemo {
    int a=0;
    boolean flag=false;

    /**
     * 多线程并发的环境下，编译器可能进行优化重排导致语句2先于语句1执行，影响到method2的结果
     * 两个线程中使用的变量是否能保持一致性无法确定，结果不可预测
     */
    public void method1(){
        a=5;        //语句1
        flag=true;  //语句2
    }

    public void method2(){
        if (flag){
            a=a+5;
            System.out.println("******retValue:"+a);
        }
    }
}
