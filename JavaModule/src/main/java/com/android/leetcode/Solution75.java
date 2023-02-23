package com.android.leetcode;

import java.util.Random;

/**
 * author : Chip
 * time   : 2023/2/23
 * desc   : 颜色分类
 */
class Solution75 {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        Random rnd = new Random();
        sort(nums, 0, nums.length, rnd);

    }

    private void sort(int[] nums, int l, int r, Random rnd) {
        if (l >= r) {
            return;
        }


        int p = l + rnd.nextInt(r - l + 1);

        swap(nums, l, p);

//        arr[l,lt-1]：小于基准值的元素。
//        arr[lt,gt-1]：等于基准值的元素。
//        arr[gt,r]：大于基准值的元素。

        int lt = l, i = l + 1, gt = r + 1;

        while (i < gt) {
            if (nums[i] < nums[l]) {
                lt++;
                swap(nums, i, lt);
                i++;

            } else if (nums[i] > nums[l]) {
                gt--;
                swap(nums, i, gt);
            } else {
                i++;
            }
        }
        swap(nums, l, lt);
        sort(nums, l, lt - 1, rnd);
        sort(nums, gt, r, rnd);

    }

    private void swap(int[] nums, int l, int p) {
        int temp = nums[l];
        nums[l] = nums[p];
        nums[p] = temp;
    }
}