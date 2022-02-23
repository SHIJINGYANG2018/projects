package Ajava.test3;


class Test1 {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();
        System.out.println("1--" + a1.show(b));//  A-A
        System.out.println("2--" + a1.show(c)); // A-A
        System.out.println("3--" + a1.show(d));//  A-D
        System.out.println("4--" + a2.show(b));//  B-A
        System.out.println("5--" + a2.show(c));//  B-A
        System.out.println("6--" + a2.show(d));//  A-D
        System.out.println("7--" + b.show(b)); //  B-B
        System.out.println("8--" + b.show(c)); //  B-B
        System.out.println("9--" + b.show(d)); //  A-D
    }
}