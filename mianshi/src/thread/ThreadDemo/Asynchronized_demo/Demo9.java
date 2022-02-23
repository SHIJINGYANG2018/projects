package thread.ThreadDemo.Asynchronized_demo;

/**
 * 子类调用父类的同步方法
 */
public class Demo9 {
synchronized  void m(){
    System.out.println("父类");

}
public static void main(String[] args){
    new MM().m();
}
}

class MM extends Demo9 {

    @Override
    synchronized void m(){
        System.out.println("子类方法m --start");
        super.m();
        System.out.println("子类方法m --end");

    }
}
