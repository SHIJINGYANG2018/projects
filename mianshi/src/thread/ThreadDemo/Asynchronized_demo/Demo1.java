package thread.ThreadDemo.Asynchronized_demo;

/**
 * synchronized
 * 锁对象
 *   原子性
 *   可见性
 */
public class Demo1 {

    private  int count=10;

    public /*synchronized*/ void test(){
        count--;
        System.out.println(Thread.currentThread().getName()+"----"+count);
    }
    public static void main(String[] args){
        Demo1 demo1 = new Demo1();
        for (int i=0;i<5;i++){
            new Thread(demo1::test,"t"+i).start();
        }
    }
}
