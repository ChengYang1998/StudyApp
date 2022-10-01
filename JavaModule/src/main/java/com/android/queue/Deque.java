package com.android.queue;

/**
 * author : cy
 * time   : 2022/9/30
 * desc   : 双端队列实现 目前有错误
 */
public class Deque<E> {

    private E[] data;
    private int front, tail;
    private int size;

    @SuppressWarnings("unchecked")
    public Deque(int capacity) {
        data = (E[]) new Object[capacity];
        front = 0;
        tail = 0;
        size = 0;
    }

    public int getCapacity() {
        return data.length;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        /*
        遍历循环队列
         */
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    public void addFront(E e) {
        if (size == getCapacity()) {
            resize(getCapacity() * 2);
        }

        if (data[front] != null) {
            //   front = front - 1 >= 0 ? front - 1 : front - 1 + data.length;
            front = front == 0 ? data.length - 1 : front - 1;
        }
        data[front] = e;
        size++;
    }

    public void addLast(E e) {
        if(size == getCapacity()){
            resize(getCapacity() * 2);
        }

        if (data[tail] != null){
            tail = (tail + 1) % getCapacity();
        }
        data[tail] = e;
        size ++;


    }

    public E removeFront() {
        if (isEmpty()) {
            throw new RuntimeException("RemoveFront failed. Cannot remove from a empty deque.");
        }
        E ret = data[front];
        data[front] = null;
        size--;
        if (!isEmpty()) {
            front = (front + 1) % data.length;
        }

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("RemoveLast failed. Cannot remove from a empty deque.");
        }
        E ret = null;
        size--;
        //想找最后一个元素，要看 tail 前一个位置的元素，即 tail - 1 位置的元素。
        // 但如果 tail 为 0，tail - 1 为负数，
        // 此时，前一个位置的元素实际上在 data.length - 1 的位置，所以要做一个判断。
        if (!isEmpty()) {
            if (tail - 1 != -1) {

                ret = data[tail - 1];
                data[tail - 1] = null;
                tail = tail - 1;
            } else {
                ret = data[data.length - 1];
                data[data.length - 1] = null;
                tail = data.length - 1;
            }
        }
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }


    public E getFront() {
        if (isEmpty()) {
            throw new RuntimeException("Deque si empty.");
        }
        return data[front];
    }

    public E getLast() {
        if (isEmpty()) {
            throw new RuntimeException("Deque si empty.");
        }
        if (tail - 1 < 0) {
            return data[size - 1];
        } else {
            return data[tail - 1];
        }

    }

    @SuppressWarnings("DefaultLocale")
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Deque: size = %d, capacity = %d\n", size, data.length));
        res.append("front [");
        for (int i = 0; i < size; i++) {
            res.append(data[(i + front) % data.length]);
            if (i != size - 1) {
                res.append(" ,");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {

        Deque<Integer> deque = new Deque<>(5);
        System.out.println(deque);
        deque.addFront(7);
        System.out.println(deque);
        deque.addLast(0);
        System.out.println(deque);
        System.out.println(deque.getLast() );


    }
}
