package com.android.sort;

import java.util.Arrays;

/**
 * author : cy
 * time   : 2022/9/28
 * desc   :
 */
public class InsertionSortOP {

    private InsertionSortOP() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            E t = arr[i];
            int j;
            for (j = i; j + 1 <= arr.length - 1 && t.compareTo(arr[j + 1]) > 0; j++) {
                //元素前移
                arr[j] = arr[j + 1];
            }
            arr[j] = t;
        }

    }

//    public static void main(String[] args) {
//        Integer[] dataSize = {5, 2, 3,0, 5, 4};
//        Integer[] arr = ArrayGenerator.generateRandomArray(101, 110);
////        sort(dataSize);
//
//
//
//        SortingHelper.sortTest("InsertionSortOP", arr);
//
//        for (Integer in : arr) {
//            System.out.println(in);
//        }
//
//    }

    public static void main(String[] args) {
        int[] dataSize = {6, 6};
        for (int n : dataSize) {
            System.out.println("random array: ");
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr2 = Arrays.copyOf(arr, n);


            SortingHelper.sortTest("InsertionSort", arr);
            SortingHelper.sortTest("InsertionSortOP", arr);

            System.out.println("Order array: ");

            arr = ArrayGenerator.generateOrderedArray(n);
            arr2 = Arrays.copyOf(arr, arr.length);

            SortingHelper.sortTest("SelectionSort", arr);
            SortingHelper.sortTest("InsertionSortOP", arr);


        }


    }
}
