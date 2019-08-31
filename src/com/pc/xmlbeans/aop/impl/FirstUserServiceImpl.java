package com.pc.xmlbeans.aop.impl;

import com.pc.xmlbeans.aop.UserService;

public class FirstUserServiceImpl implements UserService {

    @Override
    public void update() {
        System.out.println("FirstUserServiceImpl update");
    }

    @Override
    public final void finalMethod() {
        System.out.println("FirstUserServiceImpl finalMethod");
    }
}
