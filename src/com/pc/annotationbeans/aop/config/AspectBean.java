package com.pc.annotationbeans.aop.config;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectBean {

    //切点指示器execution：用于匹配是连接点的执行方法（AspectJ还有其他切点指示器来定义切点表达式
    // ，用来切类和属性，但spring没有使用。springAop只是借鉴了AspectJ的风格，比AspectJ功能要弱，比如不能切属性和构造器）
    //可以使用bean切点指示器，指定切某个bean
    @Pointcut("execution(* com.pc.annotationbeans.aop.*.*())")
    private void anyMethod() {
    }// 定义一个切入点


    @Before("anyMethod()")
    public void doAccessCheck() {
        System.out.println("前置通知");
    }

//    @AfterReturning("anyMethod()")
//    public void doAfter() {
//        System.out.println("后置通知");
//    }
//
//    @After("anyMethod()")
//    public void after() {
//        System.out.println("最终通知");
//    }
//
//    @AfterThrowing("anyMethod()")
//    public void doAfterThrow() {
//        System.out.println("例外通知");
//    }
//
//    @Around("anyMethod()")
//    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
//        System.out.println("进入环绕通知");
//        Object object = pjp.proceed();// 执行该方法
//        System.out.println("退出方法");
//        return object;
//    }

//    @Pointcut("execution(* com.pc.annotationbeans.*.g(..))")
//    private void doMethod() {
//    }// 定义一个切入点
//
//    @Around("doMethod()")
//    public Object doBasic(ProceedingJoinPoint pjp) throws Throwable {
//        System.out.println("进入环绕通知...");
//        Object object = pjp.proceed();// 执行该方法
//        System.out.println("退出方法...");
//        return object;
//    }

}
