package thread.ThreadDemo.GaTomic_demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Atomic_Demo1 {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Object o = new Object();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
               // synchronized (o){
                    atomicInteger.incrementAndGet();
                    //System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    atomicInteger.set(0);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    atomicInteger.incrementAndGet();
              //  }

            }).start();

        }
        TimeUnit.SECONDS.sleep(1);
        System.out.println(atomicInteger.get());
    }
}
