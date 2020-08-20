package study.thread;

public class SingletonDemo {
    private static volatile SingletonDemo instance=null;
    private SingletonDemo(){
        System.out.println(Thread.currentThread().getName()+"\t我是构造器");
    }

    /**
     * 普通的单例模式
     */
    public static SingletonDemo getInstance(){
        if (instance==null)instance=new SingletonDemo();
        return instance;
    }

    /**
     * 单例模式DCL（double check lock,双端检锁机制）,能极大概率避免并发环境下被构造多次问题
     * 双端检锁模式不一定线程安全，因为有指令重排的存在，加入volatile才可禁止指令重排
     * 类的初始化指令：
     *  1. memory=allocate();   分配对象以内存控件
     *  2. instance(memory);    初始化对象
     *  3. instance=memory;     设置instance指向刚分配的内存地址，此时instance!=null,但对象的初始化还没有完成
     * 由于指令重排，可能出现1->3->2的执行顺序，此时instance!=null但对象未完成初始化，造成线程安全问题
     * 解决方法：声明属性时添加volatile修饰以避免指令重排：private static volatile SingletonDemo instance=null;
     */
    public static SingletonDemo getInstanceDCL(){
        if (instance==null){
            synchronized (SingletonDemo.class){
                if (instance==null){
                    instance=new SingletonDemo();
                }
            }
        }
        return instance;
    }



    public static void main(String[] args) {
        //验证确实为单例

        //单线程（main）
//        System.out.println(SingletonDemo.getInstance()==SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance()==SingletonDemo.getInstance());
//        System.out.println(SingletonDemo.getInstance()==SingletonDemo.getInstance());

        //多线程并发，情况不妙
        /* 0	我是构造器
         * 3	我是构造器
         * 2	我是构造器
         * 1	我是构造器
         */
        for (int i = 0; i < 10; i++) {
            new Thread(SingletonDemo::getInstance,String.valueOf(i)).start();
        }
    }
}
