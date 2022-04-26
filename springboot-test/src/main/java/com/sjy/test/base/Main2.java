package com.sjy.test.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author: shijingyang
 * @date: 2022/3/19
 */
public class Main2 {
    public static void main(String[] args) throws Exception {

        Class<UserController> controllerClazz = UserController.class;

        UserController userController = controllerClazz.newInstance();
        Field[] declaredFields = controllerClazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            Autowireds annotation = declaredField.getAnnotation(Autowireds.class);
            if (annotation != null) {
                declaredField.setAccessible(true);
                Class<?> type = declaredField.getType();
                Object o = type.newInstance();
                System.out.println(o);
                declaredField.set(userController, o);
            }
        }
        System.out.println(userController.getUserService());
    }
}
