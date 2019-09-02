package array;

import java.util.Arrays;

/**
 * 动态扩容的数组
 */
public class DynamicFlexArray<T> {

    private final int CAPACITY = 8;
    private int size = 0;
    private Object[] arr;

    public DynamicFlexArray(int capacity) {
        arr = new Object[capacity];
    }

    public void add(T t) {
        if (size >= arr.length) {
            flex();
        }
        arr[size++] = t;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        return (T) arr[index];
    }

    public void flex() {
        arr = Arrays.copyOf(arr, size+CAPACITY);
    }

    public static void main(String[] args) {

        DynamicFlexArray<Integer> array = new DynamicFlexArray<>(2);
        for (int i = 0; i < 20; i++) {
            array.add(i);
        }

        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }

    }

}
