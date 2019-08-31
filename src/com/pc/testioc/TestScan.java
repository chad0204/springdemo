package com.pc.testioc;

import com.pc.annotationbeans.ioc.ClassBean;
import com.pc.annotationbeans.ioc.InterfaceBean;
import com.pc.annotationbeans.ioc.config.IoCBeanConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestScan {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(IoCBeanConfig.class);
        ClassBean classBean = (ClassBean) context.getBean("classBean");
        InterfaceBean interfaceBean = (InterfaceBean) context.getBean("interfaceBeanImpl");

        classBean.f();
        interfaceBean.f();


        context.close();

    }

}
