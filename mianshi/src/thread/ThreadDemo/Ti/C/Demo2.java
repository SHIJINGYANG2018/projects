package thread.ThreadDemo.Ti.C;

import java.util.Vector;

/**
 * 有n张火车票 对应这编号
 * 同时有10个窗口对外出售
 * 写一个模拟程序
 */
public class Demo2 {
    static Vector<String> st = new Vector<>();

    static {
        for (int i = 0; i < 1000; i++) {
            st.add("票编号" + i);
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    synchronized (st) {
                        if (st.isEmpty()) break;
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("卖出" + st.remove(0) + "----" + Thread.currentThread().getName());

                    }
                }
            }).start();
        }
    }
}
