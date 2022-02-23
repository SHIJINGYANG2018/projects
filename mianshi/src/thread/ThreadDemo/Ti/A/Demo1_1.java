package thread.ThreadDemo.Ti.A;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现一个容器 ，提供各两个方法 add size
 * 写两个线程  线程1添加10个元素到容器， 线程二实现监视元素的个数，当个数为5个时，线程2给出提示并结束
 */
public class Demo1_1 {

   volatile List list = new ArrayList<Integer>();

     void add(){
        for (int i = 0; i < 10; i++) {
            list.add(i);
            System.out.println("add--------"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
     void size(){

        while (true){
            if(list.size()==5){
                System.out.println("此时list 数据为5个");
                break;
            }
        }
    }
    public static void main(String[] args)
    {
        Demo1_1 demo1 = new Demo1_1();
        new Thread(demo1::add).start();
        new Thread(demo1::size).start();
    }


}
