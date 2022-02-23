package thread.ThreadDemo.Cthreadlocal_demo;

import java.util.concurrent.TimeUnit;

public class Demo2 {
    volatile static Person1 p = new Person1();

    static  ThreadLocal<Person1> tp=new ThreadLocal<>();
    public static void main(String[] args) {
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(tp.get());
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           // p.name = "lisi";
            tp.set(new Person1());
        }).start();
    }
}
class Person1 {
    String name = "zhangsan";
}
