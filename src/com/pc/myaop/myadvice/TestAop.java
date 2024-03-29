package com.pc.myaop.myadvice;

import com.pc.myaop.myadvice.advice.AfterAdvice;
import com.pc.myaop.myadvice.advice.BeforeAdvice;
import com.pc.myaop.myadvice.advice.SurroundAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class TestAop {

    public static void test01() {
        //实例化Spring代理工厂
        ProxyFactory factory = new ProxyFactory();
        //设置被代理的对象
        factory.setTarget(new IMathImpl());
        //添加通知，横切逻辑
        factory.addAdvice(new BeforeAdvice());
        factory.addAdvice(new AfterAdvice());
        factory.addAdvice(new SurroundAdvice());
        //从代理工厂中获得代理对象
        IMath math = (IMath) factory.getProxy();
        int n1 = 100, n2 = 5;
        math.add(n1, n2);
        math.sub(n1, n2);
        math.mut(n1, n2);
        math.div(n1, n2);
    }

    public static void main(String[] args) {
        test01();
    }
}