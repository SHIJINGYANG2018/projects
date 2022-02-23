package string;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;

import  static  List.ListTest.anInt;
public class StringTest implements Serializable {
    private static final long serialVersionUID = 1L;

    public static void main(String[] args)throws  Exception{

        System.out.println(anInt);
        BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s5 = bufferedReader.readLine();
        System.out.println(s5);
        String s="s";
        String ss="s";
        StringBuffer sbf=new StringBuffer("s");
        StringBuffer stringBuffer = new StringBuffer("s");
        String s1 = new String("s");
        String s2 = new String("s");
        System.out.println(s==ss.intern());
        System.out.println(s.equals(ss));
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));
        System.out.println(sbf.equals(stringBuffer));
        System.out.println((sbf==stringBuffer)+"---------------");
        System.out.println("**********"+(s==s1));
        System.out.println(s.equals(s1));
        System.out.println(s1.hashCode());
        System.out.println(sbf.hashCode());
        System.out.println(s.hashCode());
        user s3 = new user(1, "s");
        user s4 = new user(1, "s");
       System.out.println(s3.equals(s4));
    }

}
 class user implements  Serializable{
     private static final long serialVersionUID = 1L;

        int id;
        String name;
       public user(){

        }
        public user(int id,String name){
           this.id=id;
           this.name=name;
        }
     public boolean equals(user obj) {
           if(id==obj.id&&obj.name.equals(name)){
               return  true;
           }
           return  false;
     }
 }