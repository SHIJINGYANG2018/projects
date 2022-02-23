package thread.ThreadDemo.Asynchronized_demo;

/**
 * 规则2
 * 当一个线程访问该对象的synchronized方法或synchronized代码块时，其他线程对该对象的s
 *  其他synchronized方法或者代码块访问将被阻塞
 *
 */
public class Demo3 {
    private synchronized  void test1() throws InterruptedException {

        System.out.println("synchronized方法执行---"+Thread.currentThread().getName());
        Thread.sleep(5000);
        System.out.println("synchronized方法执行结束---"+Thread.currentThread().getName());
    }
    private synchronized void  test2(){
        System.out.println("非synchronized方法执行----"+Thread.currentThread().getName());
    }
    public static void main(String[] args){
        Demo3 demo3 = new Demo3();
        new Thread(()->{
            try {
                demo3.test1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T1").start();

        new Thread(demo3::test2,"T2").start();

        /*new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    demo3.test1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });*/
    }

}
