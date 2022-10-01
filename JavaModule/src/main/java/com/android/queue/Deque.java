package com.android.queue;

/**
 * author : cy
 * time   : 2022/9/30
 * desc   : 双端队列实现 [无泛型] [浪费一个空间] [无扩容]
 */
class Deque {

    public int[] data;
    public int front, rear;

    public Deque(int k) {
        this.data = new int[k + 1];
    }


    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        //此处front - 1 + data.length 为了防止数组下标为负数
        front = (front - 1 + data.length) % data.length;
        data[front] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        data[rear] = value;
        rear = (rear + 1) % data.length;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        data[front] = 0;

        front = (front + 1) % data.length;
        return true;

    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + data.length) % data.length;
        return true;
    }


    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return data[front];

    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        int index = (rear - 1 + data.length) % data.length;
        return data[index];

    }

    public boolean isEmpty() {
        if (front == rear) {
            return true;
        }
        return false;
    }

    /**
     * 浪费一个空间不存的,所以此处用 rear循环+1 应该等于 front 判断队满
     */
    public boolean isFull() {
        if ((rear + 1) % data.length == front) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            res.append(data[i]);
            res.append(",");
        }

        return res.toString();
    }


    public static void main(String[] args) {
        Deque deque = new Deque(3);
        deque.insertLast(1);
        deque.insertLast(2);
        deque.insertFront(3);
        System.out.println(deque.toString());
    }
}
