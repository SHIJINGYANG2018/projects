package com.sjy.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: shijingyang
 * @date: 2022/3/30
 */
public class ReentrantLockTest {
    public static void main(String[] args) {
//        ReentrantLock fairLock = new ReentrantLock(true);
        ReentrantLock notFairLock = new ReentrantLock();

        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                notFairLock.lock();
                try {
                    Condition condition = notFairLock.newCondition();
                    condition.wait();
                    Thread.sleep(1000* 60);
                } catch (InterruptedException e) {

                } finally {
                    notFairLock.unlock();
                }
            }).start();
        }


//
//        fairLock.lock();
//        try {
//
//        }finally {
//            fairLock.unlock();
//        }
    }
}
