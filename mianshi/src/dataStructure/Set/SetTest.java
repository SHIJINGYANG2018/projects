package dataStructure.Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class SetTest {
    public static void main(String[] args){


        /**
         * HashSet
         */
        HashSet<String> stringHashSet = new HashSet<>();
        stringHashSet.add("s");
        stringHashSet.add("s");

        System.out.println("s".hashCode());

        System.out.println(115>>>16);
        stringHashSet.add("ly1");
        stringHashSet.add("ly2");
        stringHashSet.add("ly3");
        stringHashSet.add("ly4");
        stringHashSet.add("ly5");
        stringHashSet.add("ly6");
        stringHashSet.add("ly7");

        System.out.println(stringHashSet);

        /**
         * 迭代器遍历
         */
        Iterator<String> iterator = stringHashSet.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }
        System.out.println();
        //增强for循环
        for(String s:stringHashSet){
            System.out.print(s+" ");
        }

        System.out.println();
        System.out.println("---------------------------");
        TreeSet<String> strings = new TreeSet<>();

        strings.add("o");
        strings.add("b");
        strings.add("c");
        strings.add("d");
        strings.add("1");
        System.out.println(strings);
        System.out.println(strings.size());//表明数组已经排序

        /**
         * 迭代器   升序
         */
        System.out.println("升序");
        Iterator<String> iterator1 = strings.iterator();

        while (iterator1.hasNext()){
            System.out.print(iterator1.next());
        }
        System.out.println();

        /**
         * 迭代器 降序
         */
        System.out.println("降序");
        Iterator<String> stringIterator = strings.descendingIterator();
        while (stringIterator.hasNext()){
            System.out.print(stringIterator.next());
        }

    }

}

/**
 * 使用TreeSet 排序自定义对象 需要这个对象实现Comparable
 * 重写他的compareTo 方法
 */
class App implements  Comparable<App> {
    int id;
    String name;

    public  int compareTo(App app){
        int num=this.id-app.id;

        return num==0?this.name.length()-app.name.length():num;

    }

}
