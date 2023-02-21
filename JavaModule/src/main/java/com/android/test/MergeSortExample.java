package com.android.test;

import java.util.Arrays;
import java.util.Random;

public class MergeSortExample {
    public static void main(String[] args) {
        int[] array = generateRandomArray(50);
        System.out.println("Original array: " + Arrays.toString(array));
        mergeSort(array, 0, array.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

    // 生成指定数量的随机整数数组
    private static int[] generateRandomArray(int count) {
        Random random = new Random();
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    // 归并排序
    private static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    // 归并两个有序数组
    private static void merge(int[] array, int left, int middle, int right) {
        int[] leftArray = Arrays.copyOfRange(array, left, middle + 1);
        int[] rightArray = Arrays.copyOfRange(array, middle + 1, right + 1);

        int i = 0;
        int j = 0;
        int k = left;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftArray.length) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightArray.length) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}

