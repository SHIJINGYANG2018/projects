package com.sjy.test.xunhuan;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: shijingyang
 * @date: 2022/3/15
 */

public class A {

    @Autowired
    private B b;

    private Integer age;


    private String name;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

