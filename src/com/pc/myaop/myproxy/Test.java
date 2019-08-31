package com.pc.myaop.myproxy;

public class Test {

    public static void main(String[] args) {

        UserServiceProxy proxy = new UserServiceProxy();
        //这里必须用接口接收代理对象,而不能用接口实现类
        UserService userp = (UserService) proxy.getProxy(new UserServiceImpl());
        userp.addUser();


        UserServiceCglib cglib = new UserServiceCglib();
        //这里创建的代理类对象相当于是业务类的子类
        UserServiceImpl userc = (UserServiceImpl) cglib.getProxy(new UserServiceImpl());
        userc.addUser();
        userc.update();


    }

}
