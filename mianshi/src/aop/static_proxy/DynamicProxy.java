package aop.static_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {

    //返回一个代理对象
    public static Object agent(Class interfaceClazz, Object proxy) {
        return Proxy.newProxyInstance(interfaceClazz.getClassLoader(), new Class[]{interfaceClazz},
                new MyHandler(proxy));
    }
    static class MyHandler implements InvocationHandler {
        //代理对象
        private Object proxyInstance;

        public MyHandler(Object proxyInstance) {
            this.proxyInstance = proxyInstance;
        }
        /**
         proxy：被代理的类实例
         */
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("before");
            //执行指定方法
            Object invoke = method.invoke(proxyInstance, args);
            System.out.println("after");
            return invoke;
        }
    }
    public static void main(String[] args) {
        //这里必须转成接口，包括参数中的Persion.class否则会报错
        Persion proxy = (Persion) DynamicProxy.agent(Persion.class, new Student("tom"));
        proxy.pay();
    }

}
