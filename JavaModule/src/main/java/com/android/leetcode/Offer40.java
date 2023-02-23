package com.android.leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * author : Chip
 * time   : 2023/2/23
 * desc   : 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * 限制：
 * <p>
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 */
public class Offer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
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
