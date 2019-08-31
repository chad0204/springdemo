package com.pc.annotationbeans.ioc.impl;

import com.pc.annotationbeans.ioc.ClassBean;
import com.pc.annotationbeans.ioc.Dessert;
import com.pc.annotationbeans.ioc.InterfaceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import sun.security.krb5.internal.crypto.Des;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Service
public class InterfaceBeanImpl implements InterfaceBean {
    public InterfaceBeanImpl() {
        System.out.println("InterfaceBeanImpl 构造器");
    }

    /*@Autowired*/
    private ClassBean classBean;

    /* @Autowired
     public InterfaceBeanImpl(ClassBean classBean) {
         this.classBean = classBean;
     }*/
    @Autowired
    public void setClassBean(ClassBean classBean) {
        this.classBean = classBean;
    }


    //由于两个实现类，所以会报NoUniqueBeanDefinitionException。
    // 解决办法：1.用@Primary标示首选bean
    //          2.定义注入的属性名时，使用bean的名称，Dessert cake[cookies]
    //          3.使用@Qualifier限定装配的bean,@Qualifier("cake")
    //          4.使用@Resource(name="cake")，指定Bean名称,@Resource不是spring而是java自带的
    @Autowired
    @Qualifier("cake")
    Dessert dessert1;

    @Autowired
    @Qualifier("cake")
    Dessert dessert2;


    @Override
    public void f() {
        System.out.println("interfaceBean f()");
        classBean.f();
        dessert1.taste();
        System.out.println(dessert1);
        System.out.println(dessert2);
    }


    @PostConstruct//初始化方法的注解方式  等同与init-method=init  
    public void init() {
        System.out.println("调用初始化方法....");
    }

    @PreDestroy//销毁方法的注解方式  等同于destory-method=destory 
    public void destory() {
        System.out.println("调用销毁化方法....");
    }


}
