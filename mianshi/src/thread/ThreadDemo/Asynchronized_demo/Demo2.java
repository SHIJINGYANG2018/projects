package thread.ThreadDemo.Asynchronized_demo;

/**
 * 规则
 * 1：当一个线程访问某个对象的synchronized的方法或者代码块时，其他线程可以访问该对象的d
 * 非synchronized修饰的方法和代码块
 */
public class Demo2 {


    private synchronized void test1() {
        System.out.println("synchronized方法执行---" + Thread.currentThread().getName());
    }

    private void test2() {
        System.out.println("非synchronized方法执行----" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        new Thread(demo2::test1, "T1").start();
        new Thread(demo2::test2, "T2").start();
    }

}
