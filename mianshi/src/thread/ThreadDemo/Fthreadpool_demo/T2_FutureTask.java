/*
package thread.ThreadDemo.Fthreadpool_demo;

import java.util.concurrent.*;

*/
/**
 * 未来任务
 * 获取未来任务的返回值
 *//*

public class T2_FutureTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
            FutureTask<Integer> task = new FutureTask<>(() -> {
            Thread.sleep(1);
            return 1000;
        });
        new Thread(task).start();   //使用线程启动任务
        System.out.println(task.get()); //阻塞 等待计算完成，然后检索其结果。


        ExecutorService service = Executors.newFixedThreadPool(5);
        Future<Integer> submit = service.submit(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 12311;
        });
        System.out.println(service);
        System.out.println(submit.get());
        System.out.println(submit.isDone());
    }
}
*/
