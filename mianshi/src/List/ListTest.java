package List;

import java.util.ArrayList;

public class ListTest  extends weekEnd{
    public  ListTest(){
        super(1);
    }
    {

    }
    public static  final int anInt=112233;
    public  static  void  main(String  [] args){


        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("1");
        stringArrayList.add("2");
        stringArrayList.add("o");
        stringArrayList.add("a");
        stringArrayList.add("c");
        stringArrayList.add("d");
        stringArrayList.add("3");
        System.out.println(stringArrayList.iterator());

        System.out.println(stringArrayList.get(1));
        System.out.println(stringArrayList.get(4));

        System.out.println(1<<4);
        System.out.println(1<<30);
    }
}
