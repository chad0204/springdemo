package com.pc.myaop.myproxy;

public class UserServiceImpl implements UserService {

    @Override
    public void addUser() {
        System.out.println("添加一个用户");
    }

    //这个方法不是实现接口方法，而是自定义的方法，不能用jdk代理
    public void update() {
        System.out.println("修改用户");
    }
}
