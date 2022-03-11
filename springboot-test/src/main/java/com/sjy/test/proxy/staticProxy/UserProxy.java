package com.sjy.test.proxy.staticProxy;

/**
 * @author: shijingyang
 * @date: 2022/3/3
 */
public class UserProxy {
    User user;

    public UserProxy(User user) {
        this.user = user;
    }

    public void pay() {
        System.out.println("naqian");
        user.pay();
        System.out.println("zouren");
    }
}
