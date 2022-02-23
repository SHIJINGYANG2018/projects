package thread.ThreadDemo.Ti.B;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * 写一个固定容量的同步容器，拥有put和get方法 以及getCount方法
 * 能够支持 2 个生产线程  以及10 个消费线程的阻塞调用
 * 使用wait()   notify/notify 实现
  */
public class Demo2_1 {
    ArrayList<Integer> list=new ArrayList<>();

    int max=20;  //最大20个

    int count=0 ;

    synchronized  void put (){
             //轮询
        while (getCount()==max){  //使用while 是当线程唤醒的时候 可以再判断一次  防止出错
                           // 如果是if   当被唤醒  可是此时的size=20，他将向下执行  再次添加信息  最大容量就是20
                            // 所以 出现错误
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("put+1++++++++++"+getCount());
        list.add(1);
        ++count;
        this.notifyAll();//
    }
    synchronized  void get(){
        while (getCount()==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("get-1-------"+(getCount()-1));
        list.remove(0);
        count--;
        this.notifyAll();
    }
    synchronized int getCount(){
        return list.size();
    }
        public static void main(String[] args){
        Demo2_1 demo2_1 = new Demo2_1();
        for (int i = 0; i < 10; i++) {
                new Thread(()->{
                for (int j = 0; j < 5; j++) {
                    demo2_1.get();
                }
            }).start();
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                for(int j=0; j<25; j++){

                    demo2_1.put();
                }
            }).start();
        }
    }



}
