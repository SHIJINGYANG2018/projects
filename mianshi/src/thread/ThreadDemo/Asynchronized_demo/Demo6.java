package thread.ThreadDemo.Asynchronized_demo;

import java.util.concurrent.TimeUnit;

public class Demo6 {
    public static void main(String[] args)throws  Exception
    {
        Demo6 demo6 = new Demo6();
        demo6.theath1();
        demo6.timeUnit();

    }
    public  void timeUnit() throws Exception{
        long begin = System.currentTimeMillis();

        for (int i = 0; i <1000 ; i++) {
            TimeUnit.SECONDS.sleep(1);
        }

        long  end= System.currentTimeMillis();
    System.out.println("TimeUnit.SECONDS.sleep(10)---"+(end-begin));

    }
    public  void theath1() throws Exception{
        long begin = System.currentTimeMillis();

        for (int i = 0; i <1000 ; i++) {
            Thread.sleep(10);
        }
        long  end= System.currentTimeMillis();
        System.out.println("Thread.sleep(10);---"+(end-begin));

    }
}
