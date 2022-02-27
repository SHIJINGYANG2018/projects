package com.sjy.test.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {


    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Appconfig.class);
        System.out.println(annotationConfigApplicationContext.getBean(X.class));
    }
}
