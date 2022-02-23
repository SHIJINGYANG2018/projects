package thread.ThreadDemo.Asynchronized_demo;

import java.util.concurrent.TimeUnit;

/**
 * 死锁实例
 */
public class Demo8 {
    Object o1 = new Object();
    Object o2 = new Object();

    public static void main(String[] args) {

        Demo8 demo8 = new Demo8();
        new Thread(()->{
            try {
                demo8.test1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                demo8.test2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

    void test1() throws InterruptedException {
        synchronized (o1) {
            System.out.println(Thread.currentThread().getName()+"test1start");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("调用test2");

            test2();
        }
    }

    void test2()throws  InterruptedException {
        synchronized (o2) {
            System.out.println(Thread.currentThread().getName()+"test2start");
            TimeUnit.SECONDS.sleep(2);
            System.out.println("调用test1");
            test1();
        }
    }

}

