package com.pc.annotationbeans.aop.impl;

import com.pc.annotationbeans.aop.UserService;
import org.springframework.stereotype.Component;

@Component
public class SecondUserServiceImpl implements UserService {

    @Override
    public void update() {
        System.out.println("SecondUserServiceImpl update");
    }

    @Override
    public final void finalMethod() {
        System.out.println("SecondUserServiceImpl finalMethod");
    }
}
