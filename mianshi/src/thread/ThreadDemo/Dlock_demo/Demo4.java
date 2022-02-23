package thread.ThreadDemo.Dlock_demo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁
 */
public class Demo4 {

    ReentrantLock lock=new ReentrantLock(true); //公平锁 非公平锁  默认非公平锁

   void test1(){
       for (int i = 0; i < 100; i++) {
           lock.lock();
           try {
               System.out.println(Thread.currentThread().getName());
               Thread.sleep(100);
           } catch (Exception e) {
               e.printStackTrace();
           }finally {
               lock.unlock();
           }

       }
   }
   public static void main(String[] args){
       Demo4 demo4 = new Demo4();
       new Thread(demo4::test1,"t1").start();
       new Thread(demo4::test1,"t2").start();
       new Thread(demo4::test1,"t3").start();

   }
}
