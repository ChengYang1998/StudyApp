package com.android.sort;

/**
 * author : cy
 * time   : 2022/9/23
 * desc   : LinearSearch
 */
public class LinearSearch {
    private LinearSearch() {
    }

//    public static int search(Student[] data, Student target) {
//        for (int i = 0; i < data.length; i++) {
//            //判断类对象 ==判断引用相等 equal判断值相等
//            if (data[i].equals(target)) {
//                return i;
//            }
//        }
//        return -1;
//    }


//    public static void main(String[] args) {
//        Student[] students = {new Student("aaa"),
//                new Student("bbb"),
//                new Student("ccc")};
//        Student bobo = new Student("bbb");
//        int res3 = LinearSearch.search(students, bobo);
//        System.out.println(res3);
//    }

    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] dataSize = {1000000, 10000000};
        for (int n : dataSize) {
            Integer[] data = ArrayGenerator.generateOrderedArray(n);

            long startTime = System.nanoTime();
            for (int k = 0; k < 100; k++) {
                LinearSearch.search(data, n);
            }
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;
            System.out.println(n + ":" + time);
        }

    }
}
