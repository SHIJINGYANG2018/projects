package string;

public class Stringdif {
    public static void main(String[] args){

        String s1 = new String("sjy");
        String s2 = new String("sjy");
        String s3="sjy";
        String l=s1+"1";
        String y=s1+"1";

        System.out.println(s1);
        System.out.println(l==y);
        System.out.println(s1==s3);
    }
}
