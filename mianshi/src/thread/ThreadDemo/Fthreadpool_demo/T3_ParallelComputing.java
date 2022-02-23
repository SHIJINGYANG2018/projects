package thread.ThreadDemo.Fthreadpool_demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 并行计算
 * 线程池  固定个数的线程池
 * 使用线程池  计算1-200000内  是是质数的值  一级个数
 */
public class T3_ParallelComputing {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long start = System.currentTimeMillis();
        getPrime(1,200000);
        long end = System.currentTimeMillis();

        System.out.println(end-start);

        long start1 = System.currentTimeMillis();

        /**
         * 启动一个线程池
         */
        ExecutorService service = Executors.newFixedThreadPool(4);

        Mytask mytask1 = new Mytask(1, 80000);
        Mytask mytask2 = new Mytask(80001, 130000);
        Mytask mytask3 = new Mytask(130001, 160000);
        Mytask mytask4 = new Mytask(130001, 200000);

        Future<List<Integer>> submit1 = service.submit(mytask1);
        Future<List<Integer>> submit2 = service.submit(mytask2);
        Future<List<Integer>> submit3 = service.submit(mytask3);
        Future<List<Integer>> submit4 = service.submit(mytask4);

        List<Integer> integers1 = submit1.get();
        List<Integer> integers2 = submit2.get();
        List<Integer> integers3 = submit3.get();
        List<Integer> integers4 = submit4.get();

        long end1 = System.currentTimeMillis();
        System.out.println(end1-start1);
        service.shutdown();
    }

    /**
     * 创建任务  因为有返回值所以使用Callable
     */
    static  class Mytask implements Callable<List<Integer>>{

        int start;
        int end;

        public Mytask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public List<Integer> call(){
            return getPrime(start,end);
        }
    }

    /*
     *判断一个是不是质数
     */
    static boolean isPrime(int num) {
        for(int i=2; i<=num/2; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
    /*
    范围
     */
    static List<Integer> getPrime(int start, int end) {
        List<Integer> results = new ArrayList<>();
        for(int i=start; i<=end; i++) {
            if(isPrime(i)) results.add(i);
        }
        return results;
    }
}
