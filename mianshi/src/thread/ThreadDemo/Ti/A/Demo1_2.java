package thread.ThreadDemo.Ti.A;


import java.util.ArrayList;
import java.util.List;

/**
 * 实现一个容器 ，提供各两个方法 add size
 * 写两个线程  线程1添加10个元素到容器， 线程二实现监视元素的个数，当个数为5个时，线程2给出提示并结束
 * wait 会释放锁   notify  不会释放锁
 */
public class Demo1_2 {
     List list = new ArrayList<Integer>();
    Object obj=new Object();
     void add(){
         synchronized (obj){
             for (int i = 0; i < 10; i++) {
                 list.add(i);
                 System.out.println("add--------"+i);
                 try {
                     Thread.sleep(1000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 if(list.size()==5){
                     obj.notify();
                     try {
                         obj.wait();
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
             }
         }
    }
    void size(){
         synchronized (obj){
                 if(list.size()!=5){
                     try {
                         obj.wait();
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }
                 System.out.println("5个元素了");
                 obj.notify();
         }
    }
    public static void main(String[] args)
    {
        Demo1_2 demo2 = new Demo1_2();
        new Thread(demo2::size).start();  //监听
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(demo2::add).start();
    }
}
