package Ajava.test5;

public class Student extends People {
    public Student() {
         System.out.println(1);

    }

    public void go(){
        System.out.println("Student -- go");
        go2();
    }
    public void go2(){
        System.out.println("Student -- go2");
    }

}
