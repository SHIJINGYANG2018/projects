package com.sjy.test.test;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class MybeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MybeanPostProcessor" +"postProcessBeforeInitialization "+ bean+beanName);
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MybeanPostProcessor" +"postProcessAfterInitialization "+  bean+beanName);
        return null;
    }
}
