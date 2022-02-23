package aop.static_proxy;

public class Student implements Persion{

    String name;

    public Student(String name) {
        this.name = name;
    }
    @Override
    public void pay() {
        System.out.println(name + " pay!");
    }
}
