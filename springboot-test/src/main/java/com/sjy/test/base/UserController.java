package com.sjy.test.base;

/**
 * @author: shijingyang
 * @date: 2022/3/19
 */
public class UserController {
    @Autowireds
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
