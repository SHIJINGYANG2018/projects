package Ajava.test4;

public class T {

    {
        System.out.println(7);
    }
    static {
        System.out.println(8);
    }

    public static void main(String[] args){
        S s=new S();
        T t = new T();
        System.out.println(9);

    }
}
