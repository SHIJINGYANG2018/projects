package com.sjy.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: shijingyang
 * @date: 2022/3/30
 */
public class CountDownLTest {

    private static  Random random = new Random();

    public static void main(String[] args) {
//
        ConcurrentHashMap<String, String> stringStringConcurrentHashMap = new ConcurrentHashMap<>();
        stringStringConcurrentHashMap.put(",",",");
        HashMap<String, String> map = new HashMap<>();
        map.put("","");
        AtomicInteger atomicInteger = new AtomicInteger(1);
        atomicInteger.addAndGet(1);
        atomicInteger.incrementAndGet();
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(4);
        integers.add(5);
        integers.add(9);
        CountDownLatch countDownLatch = new CountDownLatch(integers.size());
        for (int i = 0; i < integers.size(); i++) {

            TaskTest taskTest = new TaskTest(countDownLatch, integers.get(i));
            taskTest.start();
        }
        try {
            System.out.println("kaishi");
            countDownLatch.await();
            System.out.println("结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class TaskTest extends Thread {

        CountDownLatch countDownLatch;
        int a;

        public TaskTest() {
        }

        public TaskTest(CountDownLatch countDownLatch, int a) {
            this.countDownLatch = countDownLatch;
            this.a = a;
        }

        @Override
        public void run() {
            long start = System.currentTimeMillis();
            while (true) {
                if (random.nextInt(10) == a) {
                    System.out.println("找到" + a + "   :" + (System.currentTimeMillis() - start));
                    break;
                }else{
                    try {
                        Thread.sleep(a* 200L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            countDownLatch.countDown();

        }
    }
}
