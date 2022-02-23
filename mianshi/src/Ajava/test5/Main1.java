package Ajava.test5;

public class Main1{


    public static void main(String[] args){
        p p1 = new p(1,"sjy1");
        p p2 = new p(2,"sjy2");

        swap(p1,p2);

        System.out.println("a---"+p1.getB());
        System.out.println("b----"+p2.getB());
        int a=1;
        st(a);
        System.out.println(a);
    }
    public static  void swap(p a,p b){
        p y=a;
        a=b;
        b=y;
        a.setB("ly1");
        b.setB("ly2");
        System.out.println("a---"+a.getB());
        System.out.println("b----"+b.getB());
    }
    public static void st(int a){

    }
    static class p{
        int a;
        String b;

        public p(int a, String b) {

            this.a = a;
            this.b = b;

        }

        public int getA() {

            return a;
        }

        public String getB() {
            return b;
        }

        public void setB(String b) {
            this.b = b;
        }
    }
}
