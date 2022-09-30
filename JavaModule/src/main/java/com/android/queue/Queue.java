package com.android.queue;

/**
 * author : cy
 * time   : 2022/9/30
 * desc   :
 */
public interface Queue<E> {
    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();
}
