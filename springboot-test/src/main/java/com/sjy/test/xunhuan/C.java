package com.sjy.test.xunhuan;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: shijingyang
 * @date: 2022/3/16
 */
public class C {
    private  String name;

    @Autowired
    private B b;

    public C() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }
}
