package com.android.array;

/**
 * author : cy
 * time   : 2022/9/28
 * desc   :
 */
public class Array<E> {
    private E[] data;
    private int size;

    /**
     * 构造函数
     *
     * @param capacity
     */
    @SuppressWarnings("unchecked")
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造,默认容量为10
     */
    public Array() {
        this(10);
    }

    /**
     * @return 数组元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * @return 数组容量
     */
    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 在index个位置插入新元素e
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (size == data.length) {
//            throw new IllegalArgumentException("Array is full");
            resize(2 * data.length);


        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index < 0 || index > size");
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];

        }
        data[index] = e;
        size++;
    }

    /**
     * 动态数组
     *
     * @param newCapacity 新数组容量
     */
    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size = %d , capacity = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

    public E[] getData() {

        return data;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index < 0 || index > size");
        }

        return data[index];
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index < 0 || index > size");
        }

        data[index] = e;
    }

    /**
     * @param e
     * @return 数组是否包含元素e
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param e
     * @return 数组中元素e的索引, 不存在则返回-1
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从数组中删除index位置的元素
     *
     * @param index 删除index位置的元素
     * @return 删除的元素
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index < 0 || index > size");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;

        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除数组中第一个元素e
     *
     * @param e
     */
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

}
