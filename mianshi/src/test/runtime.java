package test;

import java.util.ArrayList;

public class runtime {
    public static void main(String[] args){
        /*ArrayList<String> strings = new ArrayList<>();
        int i=0;
        while (true){
            strings.add(String.valueOf(i).intern());
        }*/

        String s = new String("1") + new String("2");
        System.out.println(s.intern() == s);
    }
}
