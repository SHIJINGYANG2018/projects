package thread.ThreadDemo.Bvolatile_demo;



/**
 * volatile
 *
 */
public class Demo1 {
   /*volatile*/  boolean a=true;

    void test() {
        System.out.println("start");
        while (a){

            /**
             * 当cpu很忙的时候，可能只去获取高速缓存区的内容，
             * 当某个时间点闲下来的时候此时的cpu可能就不会去获取高速缓存区的内容，而是获取主内存的内容
             * */
          /*  System.out.println("----");
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
        System.out.println("end");
    }
        public static void main(String[] args) throws InterruptedException {
            Demo1 demo1 = new Demo1();
            new Thread(demo1::test).start();

            Thread.sleep(10);
            demo1.a=false;
        }
}
