package com.sjy.test.xunhuan;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: shijingyang
 * @date: 2022/3/15
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        System.out.println(classPathXmlApplicationContext.getBean(A.class));
        System.out.println(classPathXmlApplicationContext.getBean(C.class));
        System.out.println(classPathXmlApplicationContext.getBean(C.class));
        System.out.println(classPathXmlApplicationContext.getBean(C.class));

    }
}
