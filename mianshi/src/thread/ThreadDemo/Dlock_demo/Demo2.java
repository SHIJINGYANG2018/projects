package thread.ThreadDemo.Dlock_demo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 用户替代 synchronized
 * ReentrantLock 必须手动释放锁
 * 使用synchronized锁定的时候，当抛出异常，jvm 会自动释放锁
 * 但是Lock 手动释放方  通常写在  finally中进行锁的释放
 *
 * 使用Lock 可以进行尝试锁（tryLock）
 * 当一个线程无法锁定，或者在规定时间内无法锁定，线程可以决定是否等待，
 *
 */
public class Demo2 {
    ReentrantLock lock = new ReentrantLock();

    void test1() {
        lock.lock();  //synchronized
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /*
     *  使用tryLock进行尝试锁定、不管锁定与否 方法都会执行
     *  可以根据tryLock的返回值断定是否锁
     *  可以指定 tryLock的时间
     *    由于tryLock(time)抛出异常所以要注意unLock的处理  必须放在finally中
     */
    void test2() {
       /* boolean b = lock.tryLock();
        System.out.println(b);
        if(b){
            System.out.println("test2");
            lock.unlock();
        }*/
        boolean b = false;
        try {
            b = lock.tryLock(10, TimeUnit.SECONDS);  //等10秒查看对象锁的状态
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println(b);
            if(b){
                System.out.println("test2");
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        new Thread(demo2::test1).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(demo2::test2).start();
    }
}
