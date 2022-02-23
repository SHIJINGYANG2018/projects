package thread.ThreadDemo.Dlock_demo;


import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 用户替代 synchronized
 * ReentrantLock 必须手动释放锁
 * 使用synchronized锁定的时候，当抛出异常，jvm 会自动释放锁
 * 但是Lock 手动释放方  通常写在  finally中进行锁的释放
 *
 */
public class Demo1 {

    ReentrantLock lock = new ReentrantLock();

    void test1() {
        lock.lock();  //synchronized
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void test2() {
        lock.lock();
        System.out.println("test2");
        lock.unlock();
    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        new Thread(demo1::test1).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(demo1::test2).start();
    }
}
