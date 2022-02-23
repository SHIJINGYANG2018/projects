package thread.ThreadDemo.Ti.C;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * 有n张火车票 对应这编号
 * 同时有10个窗口对外出售
 * 写一个模拟程序
 */
public class Demo3 {
    static Queue<String> st = new ConcurrentLinkedDeque<>();

    static {
        for (int i = 0; i < 1000; i++) {
            st.add("票编号" + i);
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    String poll = st.poll();
                    if(poll==null) break;
                    else
                    System.out.println("卖出" + poll + "----" + Thread.currentThread().getName());

                }
            }).start();
        }
    }
}
