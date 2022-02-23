package thread.ThreadDemo.Asynchronized_demo;

import java.util.concurrent.TimeUnit;

/**
 * 锁定某个对象o，如果o的属性发生改变，不影响锁的使用，
 * 如果o变成另外一个对象。则这个对象的锁发生改变
 * 应该避免将锁定对象的引用变成另外一个对象
 *
 * 锁的是堆内存的对象上  而不是栈内存对对象的引用
 */
public class Demo12 {
    Object obj=new Object();

    void obj1(){
        synchronized (obj){
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }

    }
    public static void main(String[] args)
    {
        Demo12 demo12 = new Demo12();
        new Thread(demo12::obj1,"t1").start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        demo12.obj=new Object();
        new Thread(demo12::obj1,"t2").start();
    }
}
