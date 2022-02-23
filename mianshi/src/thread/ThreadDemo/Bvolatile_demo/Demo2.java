package thread.ThreadDemo.Bvolatile_demo;

import java.util.ArrayList;

/**
 * 应该打印  10000*5  的 但是打印结果始终小于他
 *
 */
public class Demo2 {

    private /*volatile*/ static int count = 0;

    private static  void add() {
        for (int i = 0; i < 10000; i++) {
            //在字节码层面 /
            //getstatic 获取
            // iconst  将一个常量加载到操作数栈
            // iadd   加法指令
            // putstatic  赋值
            //   首先  一个线程 获取  count 的值  之后将count的值放入操作数栈的栈顶  “此时的栈顶是最新的数据”
            //   之后   可能其他线程  已经执行的++操作  此时的栈顶已经不是最新的数据了
            //  所以   结构会比5*10000小
            ++count;    //由于++count   count++ 都是非原子性操作
        }
    }

    public static void main(String[] args) {
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {

            threads.add(new Thread(Demo2::add, "t" + i));
        }
        threads.forEach(Thread::start);
        threads.forEach((s) -> {
            try {
                s.join(); //使主线程等待其他线程运行完成
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(Demo2.count);
    }
}
