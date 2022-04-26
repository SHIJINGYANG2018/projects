package com.sjy.test.xunhuan;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: shijingyang
 * @date: 2022/3/15
 */
public class B {
    @Autowired
    private A a;

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }


}
