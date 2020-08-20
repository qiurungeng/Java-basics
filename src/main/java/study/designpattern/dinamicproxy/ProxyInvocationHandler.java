package study.designpattern.dinamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInvocationHandler implements InvocationHandler {
    //被代理的接口
    private Object target;
    public void setTarget(Object target){
        this.target=target;
    }

    //得到生成的代理类
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    //处理代理的实例，并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());
        return method.invoke(target,args);
    }

    private void log(String string){
        System.out.println("执行了"+string+"方法");
    }
}
