package thread.ThreadDemo.Bvolatile_demo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 如果都是一些加减运算  java 提供了一些Atomic类
 * AtomicXX 类本身就是原子性的，但不能保证多个方法连续调用是原子性的（详见Demo4）
 */
public class Demo3 {
      AtomicInteger a=  new AtomicInteger(0);
    void iadd(){
        for (int i = 0; i < 10000; i++) {
            //a.getAndAdd(1);   //a++
            a.incrementAndGet(); //a++
        }
        System.out.println(Thread.currentThread().getName()+"-------"+a);

    }
    public static void main(String[] args){
        Demo3 demo3 = new Demo3();
        for (int i = 0; i < 5; i++) {
            new Thread(demo3::iadd,"t"+i).start();

        }

    }
}
