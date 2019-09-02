package array;

public class StableArray<T> {

    private int CAPACITY;
    private Object[] arr;
    private int size = 0;

    public StableArray(int capacity) {
        CAPACITY = capacity;
        arr = new Object[capacity];
    }

    public void add(T t) {
        if (size >= CAPACITY) {
            throw new ArrayIndexOutOfBoundsException();
        }
        arr[size++] = t;
    }

    public T get(int index) {
        return (T) arr[index];
    }

    public void remove(int index) {
        if (index > size) {
            throw new IllegalArgumentException();
        }
        if (index == size) {
            arr[--size] = null;
            return;
        }
        int numMoved = size - index - 1;
        System.arraycopy(arr, index + 1, arr, index, numMoved);
        arr[--size] = null;
    }

}
