package thread.ThreadDemo.Fthreadpool_demo;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class T7_WorkStealingPool {


    public static void main(String[] args) throws IOException {
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        ExecutorService service = Executors.newWorkStealingPool();
        service.execute(runnable1);
        service.execute(runnable2);
        service.execute(runnable2);
        service.execute(runnable2);
        service.execute(runnable2);
        System.in.read();
    }
}
