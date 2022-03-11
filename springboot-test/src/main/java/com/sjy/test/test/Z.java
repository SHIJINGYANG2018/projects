package com.sjy.test.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

@Component
public class Z implements ApplicationContextAware , ServletContextAware {
	@Autowired
	X x;//注入X

    //构造方法
	public Z(){
		System.out.println("Z create");
	}

    //生命周期初始化回调方法
	@PostConstruct
	public void zinit(){
		System.out.println("call z lifecycle init callback");
	}

	//ApplicationContextAware 回调方法
	@Override
	public void setApplicationContext(ApplicationContext ac) {
		System.out.println("call aware callback");
	}

	@Override
	public void setServletContext(ServletContext servletContext) {

	}
}
