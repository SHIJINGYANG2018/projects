package com.sjy.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        User bean = applicationContext.getBean(User.class);
        System.out.println(bean.getName());
    }
}
