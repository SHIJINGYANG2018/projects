package thread.ThreadDemo.Fthreadpool_demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class T5_SingleThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        System.out.println(service);
        for (int i = 0; i < 5; i++) {
            int j=i;
            service.execute(() -> {
                    System.out.println("j"+j+Thread.currentThread().getName());
            });
        }

        service.shutdown();
        System.out.println(service);

    }
}
