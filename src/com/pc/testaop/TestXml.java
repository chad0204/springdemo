package com.pc.testaop;

import com.pc.xmlbeans.aop.AuthController;
import com.pc.xmlbeans.aop.UserService;
import com.pc.xmlbeans.aop.impl.SecondUserServiceImpl;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestXml {

    public static void main(String[] args) {
        //创建Spring上下文（加载bean.xml）
//        ApplicationContext acx= new ClassPathXmlApplicationContext("beans.xml");
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("D:/workspace/work_20180709/springdemo/src/aop.xml");

        /**
         * 被代理的类必须不是final类
         * cglib直接修改class文件,创建的代理类对象相当于是业务类的子类
         */
        //spring对类使用cglib，且必须使用cglib,因为类只能使用cglib代理
        AuthController authController = (AuthController) context.getBean("authController");
        authController.update();
        authController.finalMethod();//由于是cglib动态代理final方法不可以切


        /**
         * JDK动态代理所用到的代理类在程序调用到代理类对象时才由JVM真正创建，JVM根据传进来的 业务实现类对象 以及 方法名 ，
         * 动态地创建了一个代理类的class文件并被字节码引擎执行，然后通过该代理类对象进行方法调用。
         */
        //spring对接口默认使用jdk动态代理,可以强制设置使用cglib
        UserService userService = (UserService) context.getBean("firstUserServiceImpl");
        //不能使用类来接受jdk动态代理的对象
//        FirstUserServiceImpl userService = (FirstUserServiceImpl) context.getBean("firstUserServiceImpl");
        userService.update();
        userService.finalMethod();//由于是jdk动态代理final也可以切


        /**接口强制使用cglib之后fianl方法就不可以被切了，同时可以使用类来接收*/
        //不能使用类来接受jdk动态代理的对象，但强制使用cglib后可以
        SecondUserServiceImpl secondUserService = (SecondUserServiceImpl) context.getBean("secondUserServiceImpl");
        secondUserService.update();
        secondUserService.finalMethod();//jdk动态代理final也可以切，强制使用cglib后不可以切

    }
}
