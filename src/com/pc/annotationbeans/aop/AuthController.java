package com.pc.annotationbeans.aop;

import org.springframework.stereotype.Component;

@Component
public class AuthController {

    public void update() {
        System.out.println("AuthController update");
    }

    public final void finalMethod() {
        System.out.println("AuthController finalMethod");
    }

}
