package com.sjy.test;

/**
 * @author: shijingyang
 * @date: 2021/12/13
 */
public class Test1 {

    // 一个有序数组  反转了一次，取最大值
    public static void main(String[] args) throws Exception {

        int[] aa = new int[]{8, 9, 10, 13, 14, 15, 17, 2, 3, 4, 5, 6, 7};
        int before = 0;
        int after = aa.length - 1;

        // 最终二分法，两个元素相邻 跳出循环
        while (after > before + 1) {
            int zhong = (after + before) / 2;
            if (aa[zhong] < aa[before]) {
                after = zhong;
            }
            zhong = (after + before) / 2;
            if (aa[zhong] > aa[after]) {
                before = zhong;
            }
        }
        //O(log n)
        System.out.println(aa[after]);
        System.out.println(aa[before]);

    }


}
