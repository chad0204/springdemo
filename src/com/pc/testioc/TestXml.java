package com.pc.testioc;

import com.pc.xmlbeans.ioc.InterfaceBean;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestXml {

    public static void main(String[] args) {
        //创建Spring上下文（加载bean.xml）
//        ApplicationContext acx= new ClassPathXmlApplicationContext("beans.xml");
        FileSystemXmlApplicationContext acx = new FileSystemXmlApplicationContext("D:/workspace/work_20180709/springdemo/src/bean.xml");
        //获取HelloWorld实例
        InterfaceBean bean = acx.getBean("interfaceBean", InterfaceBean.class);//在xml中配置了lazy-init为true,所以初始化在getBean中发生，注解可以使用@Lazy

        bean.f();
        acx.close();


        /**
         * annotationbeans 生命周期
         *
         * 1.Bean实例的创建
         * 2.为bean实例创建属性
         * 3.调用bean实例的初始化方法（如果有）
         * 4.使用bean
         * 5.当容器关闭时调用bean实例的销毁方法（如果有）
         *
         *
         * spring的过程：
         * 1.容器的启动（初始化）：包括BeanDefinition的载入、解析、注册。
         * 发生在refresh()的obtainFreshBeanFactory()方法中（这里并没有bean的初始化）
         *
         * 2.依赖注入：bean的实例化以及bean之间依赖关系的注入，发生在手动调用getBean()方法时。
         * 单例的bean如果没有设置lazy-init为true（默认为false），则依赖注入发生在容器启动时的
         * refresh()方法的finishBeanFactoryInitialization()中（在容器启动时就提前调用了getBean()），
         * lazy-init对原型bean的依赖注入无效，任需要手动调用getBean才发生
         *
         *
         */


    }
}
