package com.android.binarysearch;

/**
 * author : cy
 * time   : 2023/2/23
 * desc   : 二分查找法
 */
public class BinarySearch {
    private BinarySearch() {
    }

    /**
     * 递归的二分查找法
     */
    public static <E extends Comparable<E>> int searchR(E[] data, E target) {

        return searchR(data, 0, data.length - 1, target);
    }

    public static <E extends Comparable<E>> int searchR(E[] data, int l, int r, E target) {
        if (l > r) {
            return -1;
        }
        int mid = l + (r - l) / 2;
        if (data[mid].compareTo(target) == 0) {
            return mid;
        }
        if (data[mid].compareTo(target) < 0) {
            return searchR(data, mid + 1, r, target);
        }
        return searchR(data, l, mid - 1, target);
    }

    public static <E extends Comparable<E>> int search(E[] data, E target) {
        int l = 0;
        int r = data.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) == 0) {
                return mid;
            }
            if (data[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        Integer[] nums = new Integer[]{1, 2, 3, 45, 65};
        System.out.println(searchR(nums, 45));
    }

}
