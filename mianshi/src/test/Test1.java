package test;
import java.util.Scanner;
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s=new String[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                s[i]=sc.nextLine();
                String[] s1 = s[i].split(" ");
                System.out.println(s1);
            }
        }
    }
}