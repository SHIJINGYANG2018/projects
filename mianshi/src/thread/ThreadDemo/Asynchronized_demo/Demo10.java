package thread.ThreadDemo.Asynchronized_demo;

/**
 * 线程抛出异常会释放锁
 * synchronized 可见性 原子性
 */
public class Demo10 {
     int a=0;
    synchronized void test() throws InterruptedException {

      while (true){
          ++a;
          Thread.sleep(1000);
          if(a==5){
              a=a/0;
          }
          System.out.println(Thread.currentThread().getName()+"----"+a);
      }

    }
    public static void main(String[] args){
        Demo10 demo10 = new Demo10();

        new Thread(()->{
            try {
                demo10.test();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t1").start();
        new Thread(()->{
            try {
                demo10.test();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"t2").start();
    }
}
