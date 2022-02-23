package aop.p;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args){
       int[] arr= new int[]{4,3};
      mergeSort(arr,0, arr.length-1);
    }
    // 分离
    public static void mergeSort(int[]arr,int start,int end){
        // 符合条件  才能分离+
        if(start<end){
            int meddle=(end+start)/2;
            mergeSort(arr,start,meddle);
            mergeSort(arr,meddle+1,end);
            merge(arr,start,meddle,end);
        }
    }
    // 合并
    public static void merge(int[] arr,int start,int meddle,int end) {
        // 存合并数组
        int [] temp=new int[end-start+1];

        int index=0;
        //数组的起始下表
        // 左边
        int q1=start;
        // 右边
        int q2=meddle+1;
        // 假定右边先小

        while(q2<=end&&q1<=meddle){
            if(arr[q1]>=arr[q2]){
                temp[index]=arr[q2];
                q2++;
            }else{
                temp[index]=arr[q1];
                q1++;
            }
            index++;
        }
        /*while (q2<=end&&arr[q1]>=arr[q2]){
            temp[index]=arr[q2];
            index++;
            q2++;
        }
        while (q1<=meddle&&arr[q1]<arr[q2]){
            temp[index]=arr[q1];
            index++;
            q1++;
        }*/
        // 右边已经没有元素了，将左边的元素直接添加到temp中
            while (q1<=meddle){
                temp[index]=arr[q1];
                q1++;
                index++;
            }
            while (q2<=end){
                temp[index]=arr[q2];
                q2++;
                index++;
        }
        System.out.println(Arrays.toString(temp));
    }
}
