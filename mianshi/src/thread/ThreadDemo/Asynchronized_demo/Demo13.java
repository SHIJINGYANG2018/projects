package thread.ThreadDemo.Asynchronized_demo;

/**
 * 不要以字符串为锁定对象
 */
public class Demo13 {
    String name1="name";
    String name2="name";
    String name3 =new String("name");
    void m(){
        synchronized (name1){
            while (true){
                System.out.println("name1");
            }
        }
    }
    void m2(){
        synchronized (name2){
            while (true){
                System.out.println("name2");
            }
        }
    }
    void m3(){
        synchronized (name3){
            while (true){
                System.out.println("name3");
            }
        }
    }
    public static void main(String[] args){
        Demo13 demo13 = new Demo13();

        new Thread(demo13::m).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(demo13::m2).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(demo13::m3).start();

    }

}
