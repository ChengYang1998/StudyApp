package com.android.javamodule;

/**
 * author : cy
 * time   : 2022/9/26
 * desc   : Student
 */
public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
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
}
