package com.sjy.test.aop;

/**
 * @author: shijingyang
 * @date: 2022/3/16
 */
public class B {

    public void beforSay(){
        System.out.println("前置通知");
    }

    public void afterSay(){
        System.out.println("后置通知");
    }
}
