package dataStructure.QueueTest;



import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

public static void main(String[] args)
{

    /**
     * 队列初始化
     */
    Queue<Integer> integers =new LinkedList<>();

    /**
     * 插入   offer    add
     *
     * @return   boolean
     */
    integers.offer(1);
    integers.offer(2);
    integers.add(3);
    integers.add(4);
    integers.offer(5);
    System.out.println(integers);

    /**
     * 删除元素值为2 的元素
     */
    integers.remove(2);

    System.out.println(integers);
    /**
     * 删除索引为0 的元素
     */
    ((LinkedList<Integer>) integers).remove(0);


    System.out.println(integers);

    /**
     * 删除   队列中的索引为1的元素   并返回其删除的值
     *
     * remove
     * poll
     *
     */
    System.out.println(integers.remove());
    System.out.println(integers.remove());
    System.out.println(integers.poll());
    System.out.println(integers);

    /**
     * 获取队列的头部
     * 当队列为空时
     * element  抛出异常
     * peek   不会异常  只会返回null
     */
    System.out.println(integers.peek());
    System.out.println(integers.element());



}
}
