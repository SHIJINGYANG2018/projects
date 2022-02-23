package thread.ThreadDemo.Bvolatile_demo;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo4 {
    AtomicInteger a=  new AtomicInteger(0);

      void iadd(){
        for (int i = 0; i < 10000; i++) {
            if(a.get()>10000){
                a.getAndAdd(1);   //a++
            }
            a.incrementAndGet(); //a++
        }


    }
    public static void main(String[] args){
        Demo4 demo4 = new Demo4();
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            threads.add(new Thread(demo4::iadd, "t" + i));
        }
        threads.forEach(Thread::start);
        ////使主线程等待其他线程运行完成
        threads.forEach((c) -> {
            try {
                c.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(demo4.a);
    }
}
