package thread.ThreadDemo.Asynchronized_demo;

import java.util.concurrent.TimeUnit;

/**
 * 一个线程调用一个对象的synchronized方法，这个方法可以调用该对象的其他synchronized封装的方法
 * 一个线程调用已有对象的锁，再次申请的时候仍然可以获得这个锁
 * 也就是 synchronized 获得的锁是可重入的
 */
public class Demo7 {

    public synchronized  void test1() throws InterruptedException {
        System.out.println("test1");

        TimeUnit.SECONDS.sleep(1);
        ssss();
    }
    public  synchronized void ssss() throws InterruptedException {
        System.out.println("ssss");

        TimeUnit.SECONDS.sleep(1);
    }
    public static void main(String[] args){
        Demo7 demo7 = new Demo7();
        new Thread(()->{
            try {
                demo7.test1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "ss").start();

        //demo7.test1();
    }
 }
