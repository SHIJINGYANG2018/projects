package com.sjy.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: shijingyang
 * @date: 2021/12/13
 */
public class Test2 {
    static ReentrantLock lock = new ReentrantLock();

    static int j = 0;
    public static void main(String[] args) throws Exception {

        for (int i = 0; i < 10; i++) {

            new Thread(()->{
                try {
                    lock.lock();
                    lock.lock();
                    j++;
                }finally {
                    System.out.println(lock.toString());
                    lock.unlock();
                }

            }).start();
        }
        TimeUnit.MILLISECONDS.sleep(3000);
        System.out.println(j);


    }


}
