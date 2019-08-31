package com.pc.xmlbeans.aop.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

public class AspectBean {

    public void beforeAdvice() {
        System.out.println("前置通知");
    }

}
