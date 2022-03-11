package com.sjy.test.proxy.staticProxy;

/**
 * 静态代理
 *
 * 1、创建代理类，实现代理接口
 * 2、在类中维护一个代理对象，通过构造器初始化代理对象
 * 3、实现接口方法，并在调用时，调用接口的相同方法，实现，前后拦截
 * @author: shijingyang
 * @date: 2022/3/3
 */
public class Main {
    public static void main(String[] args) {
        AdminService adminService = new AdminServiceImpl();
        AdminServiceProxy adminServiceProxy = new AdminServiceProxy(adminService);
        adminServiceProxy.update();

    }
}
