package sort;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 1、交换排序： 1、冒泡排序 2、快速排序
 * 2、插入排序： 1、直接插入排序 2、希尔排序
 * 3、选择排序： 1、简单选择排序  2、堆排序
 * 4、归并排序
 * 5、基数排序
 */
public class Sort_demo {
    private static int[] ints = new int[10];
    private static Random r = new Random();

    static {
        for (int i = 0; i < ints.length; i++) {
            ints[i] = r.nextInt(100);
        }
        System.out.println(Arrays.toString(ints));
    }


    /**
     *  依次判断相邻的元素    判断  交换位置
     *  原理： 跟冒泡原理一样，泡越大，他越在后面。假设此时在最下面生成一个最大的泡泡，
     *  但是，之前生成的其他泡泡大小不变，也静止不动。
     *  那这个大泡泡，会不停的往上窜，最终达到顶峰。
     *  这就是 相邻的泡泡比较，只有跟最大的泡泡一个一个的交换位置，达到顶峰的。
     */
    //冒泡排序   小——>大
    private static void BubbleSort(int[] ints1) {
        // 循环多少遍
        for (int i = 0; i < ints1.length; i++) {
            //比较多少次
            for (int j = 0; j < ints1.length - i - 1; j++) {
                if (ints1[j] > ints1[j + 1]) {
                    int xiao = ints1[j + 1];
                    ints1[j + 1] = ints1[j];
                    ints1[j] = xiao;
                }
            }
        }
    }

    /**
     * 快速排序
     * 使用递归
     * 原理：
     * 一个数组，首先选出一个数字元素作为判断的标准X（通常为数组的第一个元素），
     * 通过这个标准将这个数组分成两部分，将大于这个X的放在右边，将小于X 的放在左边，
     * 之后将中间的元素赋值为X ，这样可以看到，大于X的数都在右边，小于X的数都在左边
     * ，我们递归，将左/右边的数组(小于X/大于x的数组)分组
     * ints  待排序数组
     * start  数组起始位置
     * end    数组末端位置
     */
    static void quickSort(int[] ints, int start, int end) {
        if (start < end) {
            //标准数
            int stard = ints[start];
            // 记录需要排序的下标
            int low = start;
            int high = end;
            while (low < high) {
                //右边的数子比标准数大
                while (low < high && stard <= ints[high]) {
                    high--;
                }
                //否则使用右边的数替换标准数
                ints[low] = ints[high];
                prinf();
                //左边的数比标准数小
                while (low < high && ints[low] <= stard) {
                    low++;
                }
                ints[high] = ints[low];
            }
            // 此时  high==low
            ints[low] = stard;
            //开始递归
            //处理所有的小数字（左边）
            quickSort(ints, start, low);
            //处理所有的大数字（右边）
            quickSort(ints, low + 1, end);
        }


    }

    /**
     * 直接插入排序
     * 原理：默认某个元素 X 之前已经是有序数组，所以将 X 之前的 元素遍历比较，
     *  如果X比前边的元素小，交换位置，如果X(以交换位置了)还小，再交换位置，再比较
     *  这里的实现不是直接交换，我们是将X之前的数， 先判断，哪个是不符合条件的，我们将{"不符合",x}位置，
     *  的元素统一向后移以为，将X 插入"不符合"位置后面
     */
    public static void insterSort(int[] ints) {
        //从第二个开始比较
        for (int i = 1; i < ints.length; i++) {
            // 如果当前数字比前面数字小
            if (ints[i] < ints[i - 1]) {
                int xiao = ints[i];
                int j;
                // 遍历前边所有的数字
                for (j = i - 1; j >= 0 && xiao < ints[j]; j--) {
                    // 前面值赋值给后面值
                    ints[j + 1] = ints[j];
                }
                //不满足条件时  由于j位置上重复将他替换
                ints[j + 1] = xiao;
            }
        }
    }

    /**
     * 直接插入排序实现方式2
     */
    public static void insterSort2(int[] ints) {
        //从第二个开始比较
        for (int i = 1; i < ints.length; i++) {
            // 如果当前数字与前面数字比较
            int j=i;
            while (j>0&&ints[j] < ints[j - 1]) {
                int a=ints[j-1];
                ints[j-1]=ints[j];
                ints[j]=a;
                j--;
            }
        }
    }

    /**
     * 希尔排序
     * 首先要有一个增量（arr.length/2），对原数组进行分组,对每组使用直接插入排序算法排序，
     * 如何分？    3，2，6，4，7，1，0
     * 增量为：7/2=3   可得知{3,4,0} {2,7} {6,1} 分组比较
     * 直接排序算法，   0  2  1  3  7  6 4   可以发现 0已经放入了最前面
     * 增量为：3/2=1 直接排序算法，
     */
    public static void shellSort(int[] ints) {
        // 遍历所有的步长（增量）
        for (int i = ints.length / 2; i > 0; i /= 2) {
            // 获取每组的第一个元素
            for (int j = 0; j < i + 1; j++) {
                // 遍历本组中所有的元素  条件是  k+i 不大于ints.length-1
                for (int k = j; k + i + 1 < ints.length; k += i) {
                    //交换 还要判断  k+i 是否大于下标
                    if (ints[k] > ints[k + i]) {
                        int da = ints[k];
                        ints[k] = ints[k + i];
                        ints[k + i] = da;
                    }
                }
            }
        }
    }

    /**
     * 简单选择排序
     * 获取当前数组的最小值的 下标 ， 放在对开始的位置，之后遍历出第二个小的值放在第二个位置
     * 依次类推
     */
    //  小-->大
    public static void selectSort(int[] ints) {
        //遍历所有的数
        for (int i = 0; i < ints.length; i++) {
            int xiao = i;
            // 遍历当前的值和后面所有的值比较。获取对小值的下标
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[xiao] > ints[j]) {
                    xiao = j;
                }
            }
            // 交换
            if (xiao != i) {
                int da = ints[i];
                ints[i] = ints[xiao];
                ints[xiao] = da;
            }
        }

    }

    /**
     * 归并排序
     * 先拆分，在归并
     *  首先将一个数组，拆分成一个一个的数组，下面的范围 其实就是，锁定数组元素
     *  sjy=[5,8,2,9,1]
     *  分成一个的就是  (sjy,0,<1)=5, (sjy,1,<2)=8
     *   再将其合并
     */
    public static void mergeSort(int[] ints, int low, int hight) {
        int middle = (hight + low) / 2;
        if (low < hight) {
            // 处理左边
            mergeSort(ints, low, middle);
            // 处理右边
            mergeSort(ints, middle + 1, hight);
            // 归并
            System.out.println();
            System.out.println(low+"---"+middle+"---"+hight);
            merge(ints, low, middle, hight);
        }
    }

    // 合并操作
    public static void merge(int[] arr, int low, int middle, int hight) {

        //用于存放归并后的临时数组
        int[] temp = new int[hight - low + 1];

        //”两个数组“中第一个元素的下表
        int i = low;

        int j = middle + 1;
        // 记录存放临时数组中的下表
        int index = 0;
        // 遍历两个数组取出小的数字，放在临时数组中
        while (i <= middle && j <= hight) {
            if (arr[i] <= arr[j]) {
                temp[index] = arr[i];
                // 下标后移
                i++;
            } else {
                temp[index] = arr[j];
                j++;
            }
            index++;
        }

        while (j <= hight) {
            temp[index] = arr[j];
            j++;
            index++;
        }
        while (i <= middle) {
            temp[index] = arr[i];
            i++;
            index++;
        }
        // 临时数组放入原数组
        if (temp.length >= 0) System.arraycopy(temp, 0, arr, low, temp.length);
        System.out.println(Arrays.toString(temp));

    }

    /**
     * 基数排序
     * 通过 数组中的最大值，判断循环几遍，最高位
     */
    public static void radixRort(int[] ints) {
        int asInt = Arrays.stream(ints).max().getAsInt();
        // 通过 数组中的最大值的位数，判断循环几遍
        int length = (asInt + "").length();
        // 用于临时存放数组
        int[][] temp = new int[10][ints.length];
        // 用于记录temp中相应数组中存放的元素的个数
        int[] counts = new int[10];
        //根据最大的长度决定比较的此时
        for (int i = 0, n = 1; i < length; i++, n *= 10) {
            for (int j = 0; j < ints.length; j++) {
                //计算余数
                int a = ints[j] / n % 10;
                // 把当前遍历的数据放入临时的数据
                temp[a][counts[a]] = ints[j];
                //记录数++
                counts[a]++;
            }
            int index=0;
            // 取出数组
            for (int j = 0; j < counts.length; j++) {
                // 取出二维数组的数据 放入原数组中
                if (counts[j] != 0) {
                    for (int k = 0; k < counts[j]; k++) {
                        ints[index]=temp[j][k];
                        index++;
                    }
                    counts[j]=0;
                }
            }

        }
    }

    /**
     * 基数排序 队列实现
     */
    public static void radixQueueRort(int[] ints) {
        ArrayDeque[] integers=new ArrayDeque[10];
        for (int i = 0; i < integers.length; i++) {
            integers[i]=new ArrayDeque<Integer>(ints.length);
        }
       // ArrayQueue<Integer> integers = new ArrayQueue<>(ints.length);
        int asInt = Arrays.stream(ints).max().getAsInt();
        int length = (asInt + "").length();

        //根据最大的长度决定比较的此时
        for (int i = 0, n = 1; i < length; i++, n *= 10) {
            for (int j = 0; j < ints.length; j++) {
                //计算余数
                int a = ints[j] / n % 10;
                // 把当前遍历的数据放入临时的数据
                integers[a].addLast(ints[j]);
            }
            int index=0;
            // 取出数组
            for (ArrayDeque integer : integers) {
                // 取出队列中的数据放入原数组中
                while (!integer.isEmpty()) {
                    ints[index] = (int) integer.pollFirst();
                    index++;
                }

            }

        }
    }
    public static void main(String[] args) {
        //冒泡排序
        //BubbleSort(ints);
        //快速排序
        //quickSort(ints, 0, ints.length - 1);
        //插入排序
        //insterSort(ints);
        //insterSort2(ints);
        //sheel排序
        //shellSort(ints);
        // 选择排序
        //selectSort(ints);
        //归并排序
        //mergeSort(ints, 0, ints.length - 1);
        //基数排序
        //radixRort(ints);
        radixQueueRort(ints);
        prinf();
    }

    static void prinf() {
        System.out.println(Arrays.toString(ints));
    }
}
