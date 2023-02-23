package com.android.leetcode;

import java.util.Random;

/**
 * author : Chip
 * time   : 2023/2/23
 * desc   : 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * 示例 1:
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 * 提示：
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class Solution215 {

    public static int findKthLargest(int[] nums, int k) {

        int index = nums.length - k;
        Random rnd = new Random();
        return sort(nums, 0, nums.length - 1, rnd, index);


    }

    private static int sort(int[] nums, int l, int r, Random rnd, int index) {
        if (l >= r) {
            return nums[index];
        }

        int p = l + rnd.nextInt(r - l + 1);
        swap(nums, l, p);
        // [l,lt-1]
        //[lt,gt-1]
        //[gt,r]
        int lt = l, gt = r + 1, i = l + 1;
        while (i < gt) {
            if (nums[i] < nums[l]) {
                lt++;
                swap(nums, lt, i);
                i++;
            } else if (nums[i] > nums[l]) {
                gt--;
                swap(nums, gt, i);
            } else {
                i++;
            }
        }
        swap(nums, l, lt);

        if (index < lt) {
            sort(nums, l, lt - 1, rnd, index);
        } else if (index > gt - 1) {
            sort(nums, gt, r, rnd, index);
        } else {

            return nums[index];
        }
        return nums[index];
    }


    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


}
