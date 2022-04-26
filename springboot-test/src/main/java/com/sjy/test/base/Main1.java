package com.sjy.test.base;

import org.aspectj.weaver.ast.Var;
import org.springframework.stereotype.Controller;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author: shijingyang
 * @date: 2022/3/19
 */
public class Main1 {
    public static void main(String[] args) throws Exception {
        Class<UserService> userServiceClazz = UserService.class;
        UserService userService = userServiceClazz.newInstance();
        Constructor<?>[] constructors = userServiceClazz.getConstructors();
        constructors[0].newInstance();
        System.out.println(userService);
        Class<UserController> controllerClazz = UserController.class;
        UserController controller = controllerClazz.newInstance();

        Field userServiceDeclared = controllerClazz.getDeclaredField("userService");
        String name = userServiceDeclared.getName();
        String s = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);

        Method method = controllerClazz.getDeclaredMethod(s,userServiceClazz);
        method.invoke(controller, userService);
        System.out.println(controller.getUserService());
    }
}
