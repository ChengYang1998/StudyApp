package com.android.stack;

/**
 * author : cy
 * time   : 2022/9/29
 * desc   :
 */
public interface Stack<E> {
    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}
