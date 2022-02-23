package Ajava;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream_Demo {
    static ArrayList<people> peoples = new ArrayList<>();
    static {
        for (int i = 0; i < 100; i++) {
            peoples.add(new people("sjy" + i, i + 10));
            peoples.add(new people("sjy1" + i, i + 10));
        }
    }
    static class people {
        String name;
        int age;
        public int getAge() {
            return age;
        }
        public people(String name, int age) {
            this.name = name;
            this.age = age;
        }
        @Override
        public String toString() {
            return "people{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
    public static void main(String[] args){
        //filter是条件，参数使用Lambda表达式
        /*List<people> collect = peoples.stream().filter(people -> people.getAge() >= 100).collect(Collectors.toList());
        System.out.println(collect.size());*/
        /*List<Integer> collect = peoples.stream().map(people -> {
          return   people.getAge();
        }).collect(Collectors.toList());
        System.out.println(collect);

        List<String> collect1 = peoples.stream().map(people::toString).collect(Collectors.toList());
        System.out.println(collect1);*/

        /*System.out.println(peoples);
        List<people> collect = peoples.stream().sorted(Comparator.comparingInt(people::getAge)).collect(Collectors.toList());
        System.out.println(collect);
        List<people> collect2 = peoples.stream().sorted((o1, o2) -> o2.getAge()-o1.getAge()).collect(Collectors.toList());
        System.out.println(collect2);*/

        /*List<people> collect = peoples.stream().limit(3).collect(Collectors.toList());
       // System.out.println(collect.size());
        long end,start;
        peoples.stream().forEach(people::toString);*/

        /*Set<Integer> collect = peoples.stream().map(people::getAge).collect(Collectors.toSet());
        System.out.println(collect.size());
        List<Integer> collect1 = peoples.stream().map(people::getAge).collect(Collectors.toList());

        System.out.println(collect1.size());*/

        Map<Integer, List<people>> collect = peoples.stream().collect(Collectors.groupingBy(people::getAge));
        System.out.println(collect.size());
    }
}
