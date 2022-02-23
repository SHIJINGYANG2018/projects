package thread.ThreadDemo.Asynchronized_demo;


import java.util.concurrent.TimeUnit;

/**
 *   一段银行账户的简单实例
 * 问题  只在set方法上添加 锁可以吗
 *   当一个用户一边读 一边set    根据规则3 一个线程调用synchronized 方法
 *   其他线程可以调用该对象的其他非synchronized  方法
 *   当一个线程去set 一个账户   sjy   899999999  此时线程呢只为name赋值 而 balance 没有赋值
 *   此时另一个线程  去获取sjy账户的值 ，获取的值为0
 *   此现象叫做脏读
 *  答案    所有的方法都需要添加synchronized修饰
 */
public  class  Demo5 {
    private String name;
    private double balance;

    private synchronized void set(String name, double balance){
        this.name= name;
        // 此处睡一秒  放大线程之间时间差
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance=balance;
    }
    private synchronized double getB(String name){
        return this.balance;
    }
    public static void main(String[] args){
        Demo5 demo5 = new Demo5();

        new Thread(()->demo5.set("sjy",999999999.9)).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //此时set了 name 所以主线程获取的值为0
        System.out.println(demo5.getB("sjy"));
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //已经set 完毕   获得值为 99999~~
        System.out.println(demo5.getB("sjy"));


    }
}
