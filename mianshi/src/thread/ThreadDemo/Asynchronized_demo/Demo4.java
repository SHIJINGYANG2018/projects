package thread.ThreadDemo.Asynchronized_demo;

/**
 * 规则3
 *  当一个线程访问某个对象的synchronized方法或者代码块的。其他线程对该对象
 *  的synchronized方法或者代码块访问将被阻塞
 */
public class Demo4 {
    private synchronized  void test1() throws InterruptedException {

        System.out.println("synchronized方法执行---"+Thread.currentThread().getName());
        Thread.sleep(1000);
        System.out.println("synchronized方法执行结束---"+Thread.currentThread().getName());
    }
    public static void main(String[] args){
        Demo4 demo4 = new Demo4();
        for (int i=0;i<5;i++){
            new Thread(()->{
                try {
                    demo4.test1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"T"+i).start();
        }
    }
}
