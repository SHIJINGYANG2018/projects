package thread.ThreadDemo.Ti.B;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 写一个固定容量的同步容器，拥有put和get方法 以及getCount方法
 * 能够支持 2 个生产线程  以及10 个消费线程的阻塞调用
 * 使用 lock 和 condition实现
 */
public class Demo2_2 {
    ArrayList<Integer> list = new ArrayList<>();
    int max = 20;  //最大20个
    int count = 0;
    Lock lock = new ReentrantLock();
    Condition producer = lock.newCondition();  //生产者
    Condition consumer = lock.newCondition();  //消费者

    void put() {
        lock.lock();
        try {
            while (list.size() == max) {
                    producer.await();
            }
            System.out.println("put+1++++++++++" + list.size());
            list.add(1);
            ++count;
            consumer.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

     void get() {

        lock.lock();
         try {
             while (list.size() == 0) {
                     consumer.await();
             }
             System.out.println("get-1-------" + (list.size() - 1));
             list.remove(0);
             count--;
             producer.signalAll();
         } catch (Exception e) {
             e.printStackTrace();
         }
         finally {
             lock.unlock();
         }
     }



    public static void main(String[] args){
        Demo2_2 demo2_2 = new Demo2_2();

        // 消费
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 6; j++) {
                    demo2_2.get();
                }
            }).start();
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //生产
        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                for(int j=0; j<30; j++){
                    demo2_2.put();
                }
            }).start();
        }
    }
}