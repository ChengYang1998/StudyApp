package com.android.sort;


import java.util.Arrays;

/**
 * author : cy
 * time   : 2022/9/26
 * desc   : 对大多数有序的数组,用插入排序法
 */
public class InsertionSort {
    private InsertionSort() {
    }



    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //将arr[i]插入到合适的位置 暂存 寻找插入位置 后面的元素后移
            E t = arr[i];
            int j;
            //存在内层循环终止的情况
            for (j = i; j - 1 >= 0 && t.compareTo(arr[j - 1]) < 0; j--) {
                //默认将元素后移
                arr[j] = arr[j - 1];
            }
            arr[j] = t;

        }
    }

    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        for (int i = l; i <= r; i++) {
            //将arr[i]插入到合适的位置 暂存 寻找插入位置 后面的元素后移
            E t = arr[i];
            int j;
            //存在内层循环终止的情况
            for (j = i; j - 1 >= l && t.compareTo(arr[j - 1]) < 0; j--) {
                //默认将元素后移
                arr[j] = arr[j - 1];
            }
            arr[j] = t;

        }
    }


    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            System.out.println("random array: ");
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr2 = Arrays.copyOf(arr, arr.length);


            SortingHelper.sortTest("InsertionSort", arr);
            SortingHelper.sortTest("SelectionSort", arr2);

            System.out.println("Order array: ");

            arr = ArrayGenerator.generateOrderedArray(n);
            arr2 = Arrays.copyOf(arr, arr.length);

            SortingHelper.sortTest("InsertionSort", arr);
            SortingHelper.sortTest("SelectionSort", arr2);


        }


    }
}
