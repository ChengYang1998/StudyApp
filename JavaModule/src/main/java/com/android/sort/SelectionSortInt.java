package com.android.sort;

/**
 * author : cy
 * time   : 2022/9/26
 * desc   : SelectionSortInt
 */
public class SelectionSortInt {
    private SelectionSortInt() {
    }

    public static void sort(int[] arr) {
        //arr[0..i)有序 ; arr[i,n)无序
        for (int i = 0; i < arr.length; i++) {
            //选择arr[i...n)中最小值索引
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("SelectionSort", arr);
        }


    }
}
