package com.android.sort;

import java.util.Random;

/**
 * author : cy
 * time   : 2022/9/26
 * desc   : 数组生成器
 */
public class ArrayGenerator {

    private ArrayGenerator() {
    }

    public static Integer[] generateOrderedArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    //生成长度为n的随机数组，数字范围为[0,bound)
    public static Integer[] generateRandomArray(int n, int bound) {
        Integer[] arr = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }

}
