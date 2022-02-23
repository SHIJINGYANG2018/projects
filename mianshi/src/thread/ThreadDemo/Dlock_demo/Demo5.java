package thread.ThreadDemo.Dlock_demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition
 * await()
 *      使线程进入等待，和Object.wait()类似，须在当前必线程持有Lock时才能调用。
 *  signal()
 *      唤醒此condition等待队列中的首节点（等待最久的节点），和Object.notify()类似，必须在当前线程持有Lock时才能调用。
 *  signalAll()
 *      唤醒此condition等待队列中的所有节点，和Object.notifyAll()类似，必须在当前线程持有Lock时才能调用。
 *
 */
public class Demo5 {
    ReentrantLock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    volatile boolean boo=true;
    void test(){
        lock.lock();
        while(boo){
            try {
                condition1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
        condition1.signalAll();


    }
    public static void main(String[] args){

        new Thread(()->{


        });

    }
}
