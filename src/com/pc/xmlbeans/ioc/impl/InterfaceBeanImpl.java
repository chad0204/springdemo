package com.pc.xmlbeans.ioc.impl;

import com.pc.xmlbeans.ioc.ClassBean;
import com.pc.xmlbeans.ioc.InterfaceBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class InterfaceBeanImpl implements InterfaceBean {
    public InterfaceBeanImpl() {
        System.out.println("InterfaceBeanImpl 构造器");
    }

    ClassBean classBean;

    public ClassBean getClassBean() {
        return classBean;
    }

    public void setClassBean(ClassBean classBean) {
        this.classBean = classBean;
    }

    @Override
    public void f() {
        System.out.println("interfaceBean f()");
        classBean.f();
    }

    public void init() {
        System.out.println("调用初始化方法....");
    }

    public void destory() {
        System.out.println("调用销毁化方法....");
    }


}
