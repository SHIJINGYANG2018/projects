package com.sjy.test.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: shijingyang
 * @date: 2022/3/4
 */
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger1 = new AtomicInteger(1);
        AtomicInteger atomicInteger2 = new AtomicInteger(2);
        for (int i = 0; i < 100; i++) {

            new Thread(()->{
                atomicInteger1.addAndGet(1);
                atomicInteger2.addAndGet(2);
        }).start();
        }
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println(atomicInteger1);
        System.out.println(atomicInteger2);
    }
}
