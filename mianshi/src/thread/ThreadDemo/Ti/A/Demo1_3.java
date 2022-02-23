package thread.ThreadDemo.Ti.A;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 实现一个容器 ，提供各两个方法 add size
 * 写两个线程  线程1添加10个元素到容器， 线程二实现监视元素的个数，当个数为5个时，线程2给出提示并结束
 * CountDownLatch
 */
public class Demo1_3 {
    volatile List list = new ArrayList<Integer>();
    //门闩
    CountDownLatch cdl = new CountDownLatch(1);

    void add() {
        for (int i = 0; i < 10; i++) {
            list.add(i);
            System.out.println("add--------" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(list.size()==5){
                cdl.countDown(); //门闩减一
            }
        }
    }

    void size() {

        if (list.size() != 5) {
            try {
                cdl.await();  //当前线程等待，直到门闩的值为0，线程才往下执行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println("此时list 数据为5个");
    }

    public static void main(String[] args) {
        Demo1_3 demo3 = new Demo1_3();
        new Thread(demo3::size).start();  //监听
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(demo3::add).start();
    }

}
