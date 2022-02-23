package thread.ThreadDemo.Fthreadpool_demo;

import java.util.concurrent.*;

/**
 * corePoolSize  线程的大小
 * maximumPoolSize  最大连接长度
 * workQueue       队列的容量
 * keepAliveTime
 * threadFactory
 * handler
 * 
 * 
 */

public class Demo1 {

    public static void main(String[] args){

    }

    /**
     * Runnable
     * Callable
     * 区别
     * Runnable没有返回值
     * Callable有返回值
     */

    static class  mytask1 implements Runnable{
        @Override
        public void run() {
        }
    }
    static class  mytask2 implements Callable<Integer>{
        @Override
        public Integer call() throws Exception {
            return 1234;
        }
    }
}
