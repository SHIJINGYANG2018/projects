package com.sjy.test.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: shijingyang
 * @date: 2022/3/16
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-aop.xml");
        A a = ac.getBean(A.class);
        a.saying();
        C c = ac.getBean(C.class);
        c.saying1();
        c.saying1();

        a.saying();

    }
}
