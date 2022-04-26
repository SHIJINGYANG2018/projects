package com.sjy.test;

import java.util.concurrent.locks.ReentrantLock;


public class TestApplication {
    public static void main(String[] args) throws Exception {
        /*User user = new User(1,"2s");
        System.out.println(JSONObject.toJSONString(user));*/
        ReentrantLock fairLock = new ReentrantLock(true);
        ReentrantLock notFairLock = new ReentrantLock();

        notFairLock.lock();
        try {

        }finally {
            notFairLock.unlock();
        }

        fairLock.lock();
        try {

        }finally {
            fairLock.unlock();
        }

    }

}

