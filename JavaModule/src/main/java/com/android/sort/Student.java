package com.android.sort;

/**
 * author : cy
 * time   : 2022/9/26
 * desc   : Student
 */
public class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student another) {
//        if (this.score < another.score) {
//            return -1;
//        } else if (this.score == another.score) {
//            return 0;
//        } else {
//            return 1;
//        }
        return this.score - another.score;
    }

    @Override
    public boolean equals(Object student) {

        //此处this指 使用equals()方法的Student类的对象
        if (this == student) {
            return true;
        }
        //判空
        if (student == null) {
            return false;
        }
        //判断类
        if (this.getClass() != student.getClass()) {
            return false;
        }


        Student another = (Student) student;
        return this.name.equals(another.name);
    }

    @Override
    public String toString() {
        return String.format("Student(name:%s,score:%d)", name, score);
    }
}
