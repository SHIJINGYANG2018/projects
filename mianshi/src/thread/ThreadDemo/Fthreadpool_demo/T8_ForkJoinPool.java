package thread.ThreadDemo.Fthreadpool_demo;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

/**
 * 递归结果ForkJoinTask 。
 * <p>
 * 计算数组综合
 */
public class T8_ForkJoinPool {
    static long start;
    static long end;
    static int[] ints = new int[99999999];
    static int max_num = 50000;
    static Random r = new Random();

    static {
        long sum = 0;
        for (int i = 0; i < ints.length; i++) {
            ints[i] = 99999999 +r.nextInt(999999);
        }
        start=System.currentTimeMillis();
        IntStream stream = Arrays.stream(ints);
        for (int i = 0; i < ints.length; i++) {
            sum+=ints[i];
        }
        /*for (int anInt : ints) {
            sum += anInt;
        }*/
        System.out.println(sum);
        end=System.currentTimeMillis();
        System.out.println("start"+(end-start));
    }

   /* static class AddTask extends RecursiveAction {
        int start;
        int end;

        public addTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (end - start <= max_num) {
                long sum = 0L;
                for (int i = start; i < end; i++) {
                    sum+=ints[i];
                }
                System.out.println("from:" + start + " to:" + end + " = " + sum);
            }else{
                int mid=start+(end-start)/2;
                addTask addTask1 = new addTask(start, mid);
                addTask addTask2 = new addTask(mid,end);
                addTask1.fork();
                addTask2.fork();
            }


        }
    }*/
   static class AddTask extends RecursiveTask<Long> {

       private static final long serialVersionUID = 1L;
       int start, end;

       AddTask(int s, int e) {
           start = s;
           end = e;
       }

       @Override
       protected Long compute() {

           if(end-start <= max_num) {
               long sum = 0L;
               for(int i=start; i<end; i++) sum += ints[i];
               return sum;
           }

           int middle = start + (end-start)/2;

           AddTask subTask1 = new AddTask(start, middle);
           AddTask subTask2 = new AddTask(middle, end);
           subTask1.fork();
           subTask2.fork();

           return subTask1.join() + subTask2.join();
       }

   }

    public static void main(String[] args) throws IOException {
       start=System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        AddTask addTask = new AddTask(0, ints.length);
        forkJoinPool.execute(addTask);
        long result = addTask.join();

        System.out.println(result);
        end=System.currentTimeMillis();

        System.out.println("forkjoin"+(end-start));
        //System.in.read();
    }


}
