package thread.ThreadDemo.Econcurrent_container;

import sun.misc.Queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * java 高并发下的容器
 */
public class Demo1 {
    public static void main(String[] args) {


        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();

        ConcurrentSkipListMap<Object, Object> cslm = new ConcurrentSkipListMap<>();

        ArrayList<Object> objects1 = new ArrayList<>();
        //将容器转化
        List<Object> objects = Collections.synchronizedList(objects1);

        CopyOnWriteArrayList<Object> objects2 = new CopyOnWriteArrayList<>();

        Queue queue = new Queue();
        //ArrayBlockingQueue ：一个由数组结构组成的有界阻塞队列。
        //LinkedBlockingQueue ：一个由链表结构组成的有界阻塞队列。
        //PriorityBlockingQueue ：一个支持优先级排序的无界阻塞队列。
        //DelayQueue：一个使用优先级队列实现的无界阻塞队列。
        //SynchronousQueue：一个不存储元素的阻塞队列。
        //LinkedTransferQueue：一个由链表结构组成的无界阻塞队列。
        //LinkedBlockingDeque：一个由链表结构组成的双向阻塞队列。


    }
}
