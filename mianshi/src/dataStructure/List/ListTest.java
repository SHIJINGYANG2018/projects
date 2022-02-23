package dataStructure.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 迭代器的方法，是
 */
public class ListTest {
public static void main(String[] args){
    List<String> strings = new ArrayList<>();
    strings.add("a");
    strings.add("c");
    strings.add("d");
    strings.add("e");
    strings.add("1");
    strings.add("2");
    ListIterator<String> listIterator = strings.listIterator();
    listIterator.next();
    listIterator.next();
    listIterator.next();
   /* int i1 = listIterator.previousIndex();//      上一个数据的索引
    String previous = listIterator.previous(); // 获取上一个数据，并且移动光标
    System.out.println("-----上一个索引："+i1+"值为"+previous);*/
    int i = listIterator.nextIndex(); // 下一个数据的索引
    String next = listIterator.next(); //获取下一个数据，并且移动光标

    System.out.println("下一个索引："+i+"，值为"+next);
    //listIterator.remove();
    //listIterator.set("0");
    //listIterator.add("09");
    System.out.println(strings);

    Iterator<String> iterator = strings.iterator();

}
}
