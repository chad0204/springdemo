package com.pc.xmlbeans.aop;

public class AuthController {

    public void update() {
        System.out.println("AuthController update");
    }

    public final void finalMethod() {
        System.out.println("AuthController finalMethod");
    }

}
