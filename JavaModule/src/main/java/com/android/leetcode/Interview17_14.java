package com.android.leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * author : Chip
 * time   : 2023/2/23
 * desc   :
 */
public class Interview17_14 {
    public int[] smallestK(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        int index = k - 1;
        selectK(arr, 0, arr.length - 1, index, new Random());

        return Arrays.copyOf(arr, k);
    }

    public int selectK(int[] arr, int l, int r, int k, Random rnd) {

        int p = partition(arr, l, r, rnd);
        if (k == p) {
            return arr[p];
        } else if (k < p) {
            return selectK(arr, l, p - 1, k, rnd);
        } else {
            return selectK(arr, p + 1, r, k, rnd);
        }

    }

    private int partition(int[] arr, int l, int r, Random rnd) {

        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, l, p);

        int i = l + 1, j = r;
        while (true) {
            while (i <= j && arr[i] < arr[l]) {
                i++;
            }
            while (i <= j && arr[j] > arr[l]) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(arr, i, j);
            i++;
            j--;

        }
        swap(arr, l, j);
        return j;

    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
