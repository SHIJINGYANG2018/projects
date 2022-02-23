package thread.ThreadDemo.Fthreadpool_demo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class T10_ParallelStreamAPI {
    static ArrayList<people> peoples = new ArrayList<>();

    static {
        //System.out.println(Integer.MAX_VALUE);
        for (int i = 0; i < 3; i++) {
            peoples.add(new people("sjy" + i, i + 10));
            peoples.add(new people("sjy1" + i, i + 10));
        }
    }

    static class people {
        String name;
        int age;

        public String getName() {
            return name;
        }

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

    public static void main(String[] args) {

        long start;

        long end;
        Stream<T10_ParallelStreamAPI.people> stream = peoples.stream();
        Stream<T10_ParallelStreamAPI.people> peopleStream = peoples.parallelStream();
        start = System.currentTimeMillis();
        //按添加的顺序输出
        peoples.forEach(System.out::print);
        end = System.currentTimeMillis();
        System.out.println("ArrayListForeach----------------------" + (end - start));
        start = System.currentTimeMillis();
        //乱序输出
        stream.forEach(System.out::println);
        end = System.currentTimeMillis();
        System.out.println("steamForEach----------------------" + (end - start));
        start = System.currentTimeMillis();
        //按添加的顺序输出
        peopleStream.forEach(people::getAge);
        end = System.currentTimeMillis();
        System.out.println("parallelStreamForEach-------------------" + (end - start));

        start = System.currentTimeMillis();
        List<String> collect = peoples.stream()//.filter(people -> people.getAge() % 3 == 0)
                //.sorted(Comparator.comparing(people::getAge))
                .map(people::getName)
                .collect(Collectors.toList());
        end = System.currentTimeMillis();
        System.out.println(collect + "-----------------" + (end - start));
        start = System.currentTimeMillis();
        List<people> collect2 = peoples.parallelStream().filter(people -> people.getAge() % 3 == 0)
                //.sorted(Comparator.comparing(people::getAge))
                .map(people -> people)
                .collect(Collectors.toList());
        end = System.currentTimeMillis();
        System.out.println(collect2 + "-----------------" + (end - start));

        Map<Integer, List<people>> collect1 = peoples.stream()
                .filter(people -> people.getAge() > 100)
                //s.limit(3)
                .sorted(Comparator.comparingInt(people::getAge))
                .collect(Collectors.groupingBy(people::getAge));
        System.out.println(collect1);

        Iterator<people> iterator = peoples.stream().iterator();
        start=System.currentTimeMillis();
        while (iterator.hasNext()){
            iterator.next().getAge();
            // System.out.print(iterator.next());
        }
        end=System.currentTimeMillis();
        System.out.println();
        System.out.println("stream iterator"+(end-start));

    }

    /*static boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }*/
}
