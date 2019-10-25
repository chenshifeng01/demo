package com.chen.jdk.basic.day01.sort;

/**
 * 冒泡排序
 * 冒泡排序是由两个for循环组成
 * 这种排序规则如下：
 *     f1循环是进行判断list或array中有多少个就进行循环多少次
 *     f2循环是根据第一层循环进行if判断，前面大的往后移，以此来进行排序
 *
 */
public class BubbleSort {


    public static void sort(int[] a) {
        int temp = 0;
        for (int i = a.length - 1; i > 0; --i) {
            for (int j = 0; j < i; ++j) {
                //进行判断前面一个是否小于后面一个，如果小于进行互换
                if (a[j + 1] < a[j]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }


    public static void main (String[] args) {
        int[] a = {7, 1, 2, 3, 4, 5, 6};
        BubbleSort.sort(a);
    }

}
