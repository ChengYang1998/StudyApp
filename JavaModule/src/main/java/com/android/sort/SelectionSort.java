package com.android.sort;

/**
 * author : cy
 * time   : 2022/9/26
 * desc   : SelectionSort泛型方法
 */
public class SelectionSort {
    private SelectionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        //arr[0..i)有序 ; arr[i,n)无序
        for (int i = 0; i < arr.length; i++) {
            //选择arr[i...n)中最小值索引
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                //泛型E无法使用<比较,需要E实现Comparable接口
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 4, 2, 3, 6, 5};
        SelectionSort.sort(arr);
        for (int e : arr) {
            System.out.println(e + "");
        }

        Student[] students = {new Student("Alice", 98),
                new Student("Bobo", 100),
                new Student("Charles", 66)};
        SelectionSort.sort(students);
        for (Student student :
                students) {
            System.out.println(student.toString());
        }



    }
}
