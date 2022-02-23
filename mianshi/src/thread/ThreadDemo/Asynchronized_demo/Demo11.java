package thread.ThreadDemo.Asynchronized_demo;

/**
 * 对象锁：获取的是某个对象对应唯一关联的锁，如果对象是单例则也是全局锁。
 *      如非静态方法的synchronized关键字获取的就是对象锁
 * 全局锁：将synchronized关键字用在static方法上
 *        用synchronized对类的Class对象进行上锁
 * synchronized(class)代码块的作用与synchronized static方法的作用一样。
 *
 * Inner.synStaticMethod();调用的是静态同步方法，获得的是Inner类对象对应的锁，
 * 与synchronized (Inner.class)获得的是同一个锁，类对象是全局唯一的，所以类对象类对象对应的锁也叫全局锁
 *
 */
public class Demo11 {
    public static void main(String[] args) {
        Inner inner = new Inner();
        new Thread(() -> {
            try {
                Inner.synStaticMethod();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                inner.synBlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }


}

class Inner{
    public synchronized static void synStaticMethod() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "--synStaticMethod");
            Thread.sleep(100);
        }
    }
    public void synBlock() throws InterruptedException {
        synchronized (Inner.class) {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "--synBlock");
                Thread.sleep(100);
            }
        }
    }
}