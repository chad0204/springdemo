package com.pc.xmlbeans.ioc;

import org.springframework.stereotype.Component;

public class ClassBean {

    public ClassBean() {
        System.out.println("ClassBean 构造器");
    }

    public void f() {
        System.out.println("classBean  f()");
    }

}
