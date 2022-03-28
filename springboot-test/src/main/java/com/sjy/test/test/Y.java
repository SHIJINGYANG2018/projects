package com.sjy.test.test;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

@Component
public class Y implements InitializingBean , BeanNameAware, ServletContextAware {
    static  ServletContext servletContext1;
	@Autowired
	X x;
	
	public Y(){
		System.out.println("Y create");
	}

    @Override
    public void afterPropertiesSet() throws Exception {

        System.out.println("Y afterPropertiesSet");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println(" setBeanName " + name);
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        servletContext1 = servletContext;
        System.out.println(servletContext1.getContextPath());
    }
}
