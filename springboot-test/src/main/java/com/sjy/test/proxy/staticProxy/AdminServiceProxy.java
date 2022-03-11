package com.sjy.test.proxy.staticProxy;

/**
 * @author: shijingyang
 * @date: 2022/3/3
 */
public class AdminServiceProxy implements AdminService {
    AdminService adminService;

    public AdminServiceProxy(AdminService adminService) {
        this.adminService = adminService;
    }

    @Override
    public void update() {
        System.out.println("判断条件，是否有update权限");
        adminService.update();
        System.out.println("记录日志");
    }

    @Override
    public Object find() {
        System.out.println("判断条件，是否有find权限");
        return adminService.find();
    }
}
