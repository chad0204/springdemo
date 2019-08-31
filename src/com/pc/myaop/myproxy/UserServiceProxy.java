package com.pc.myaop.myproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/**
 * JDK动态代理所用到的代理类在程序调用到代理类对象时才由JVM真正创建，JVM根据传进来的 业务实现类对象 以及 方法名 ，
 * 动态地创建了一个代理类的class文件并被字节码引擎执行，然后通过该代理类对象进行方法调用。
 */
public class UserServiceProxy implements InvocationHandler {

    private Object target;

    public Object getProxy(Object target) {
        this.target = target;
        //这里的this将InvocationHandler对象传入，也就是触发了invoke()方法
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        Object result = null;

        System.out.println("预处理操作——————");
        //调用真正的业务方法
        result = method.invoke(target, objects);

        System.out.println("调用后处理——————");
        return result;
    }
}
