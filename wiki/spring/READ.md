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






getBean --> doGetBean --> createBean --> doCreateBean --> createBeanInstance --> populateBean


Bean生命周期， bean实例化完成，之后初始化，首先操作的是对bean的属性进行赋值，->>如果bean实现了Aware方法，会先执行回调回调方法，如果没有实现，就会跳过这个过程，
之后，执行before ,init方法,after，整个bean对象完整。如果关闭spring容器，会销毁bean方法，通过注解执行，通过配置文件destory-method



spring 启动过程（xml配置）
1、初始化 spring容器
2、执行refresh()
3、设置启动时间、初始化一些变量
4、创建beanFa
4、将xml配置的<bean> 读取出来，
初始化一些变量
4、



AOP
1、切面、切点、连接点、通知


### Spring300问
#### 1、谈谈岁Spring IOC的理解，原理、实现
IOC 是一个设计思想，控制反转，之前对象的实例化 是我们手动东西，现在是通过spring控制，有设计思想就有实现
他的实现就是依赖注入，我们一般通过注解@autowired修饰 的并通过 pupobean方法对 bean属性进行注入
Spring ,他是一个容器，存放对象，普通对象，bean对象都包括、一些资源，单例的bean通过一个singleObject 的 map 来存放， 并且他巧妙的通过三级缓存
来解决循环依赖的问题。 spring 也管理bean的整个的生命周期，从实例化、初始化、到使用、到销毁
#### 2、谈一下spring IOC的底层实现
首先创建一个springContext实例，并设置状态、初始值、启动时间等，之后创建beanFactory,扫描配置，讲注解的bean，配置文件的bean,
将他加载成BeanDefinition, 之后调用响应的BeanFactoryPostProcessor 对beanDefinition进行后置处理比如

#### 3、描述一下bean的生命周期
#### 4、spring是怎么解决循环依赖的
#### 5、Bean Factory 与factory bean区别
#### 6、spring中用了什么设计模式
工厂模式、代理模式、责任链模式、观察者模式等等





