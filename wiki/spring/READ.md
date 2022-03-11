## 谈谈你对Spring的理解
1、Spring是一个框架
2、为了解决应用开发的复杂性
3、可以使用注解、配置进行配置
4、使用javaBean

spring是一个框架，在我们在整个开发流程中几乎所有的框架都依赖于Spring，比如 redis,mysql,myBatis,
Spring 帮我们起到了一个SpringIOC的作用，用来承载我们整体的bean对象，他帮我们进行了整个对象的从创建到销毁的整个生命周期的管理
 我们在使用Spring的时候可以使用配置文件xml,或者注解的方式来进行相关实现， 
当我们程序开始启动之后， spring要把注解或者配置文件 定义的对象，转换成BeanDefinition,并且也要完成BeanDefinition的解析和加载，
此时可以获取到整个对象的信息之后，通过复杂的处理，后置处理器，反射 ，实例化Bean对象，
让创建完毕对象之后，也会有其他负责的操作，postProcessor 等，才能完毕，将他放到Bean工厂中，
之后就可以通过getBean获取bean对象。


Bean生命周期， bean实例化完成，之后初始化，首先操作的是对bean的属性进行赋值，->>如果bean实现了Aware方法，会先执行回调回调方法，如果没有实现，就会跳过这个过程，
之后，执行before ,init方法,after，整个bean对象完整。如果关闭spring容器，会销毁bean方法，通过注解执行，通过配置文件destory-method