package thread;

import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {

            while (true) {
                try {
                    System.out.print(1);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.interrupted();
                    break;
                }
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(3);
        try {
            Thread.sleep(1);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println(1);
    }
}
