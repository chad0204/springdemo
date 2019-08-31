package com.pc.annotationbeans.aop.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan("com.pc.annotationbeans.aop")
@Configuration
//使扫描到的bean支持aop
@EnableAspectJAutoProxy(proxyTargetClass = true)//proxyTargetClass = true强制让接口也使用cglib,相当于xml中的proxy-target-class="true"
public class BeanConfig {
}
