package com.pc.xmlbeans.aop.impl;

import com.pc.xmlbeans.aop.UserService;

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
