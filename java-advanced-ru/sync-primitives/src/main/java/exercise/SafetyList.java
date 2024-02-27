package exercise;

import java.util.*;

class SafetyList {
    // BEGIN
    private static final int DEFAULT_CAPACITY = 10;
    private int[] array;
    private int size;

    public SafetyList() {
        this(DEFAULT_CAPACITY);
    }

    public SafetyList(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    public synchronized void add(int element) {
        if (size == array.length) {
            int newCapacity = array.length * 2;
            int[] newArray = new int[newCapacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
        array[size] = element;
        size++;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return array[index];
    }

    public int getSize() {
        return size;
    }

    // END
}
