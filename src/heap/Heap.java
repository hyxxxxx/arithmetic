package heap;

import java.util.Arrays;

public class Heap {

    private int[] arr;
    private int capacity;
    private int size;

    public Heap(int capacity) {
        this.arr = new int[capacity + 1];
        this.capacity = capacity;
        this.size = 0;
    }

    public void insert(int data) {
        if (size >= capacity) {
            return;
        }
        ++size;
        arr[size] = data;   //放到最后一个节点上
        int i = size;
        while (arr[i] > arr[i / 2] && i / 2 > 0) {  //如果插入的节点比父节点大，则交换
            swap(arr, i, i / 2);
            i = i / 2;
        }
    }

    public void remove() {
        arr[1] = arr[size];
        --size;
        heapify(arr, size, 1);
    }

    private void heapify(int[] arr, int size, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= size && arr[i] < arr[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= size && arr[i] < arr[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                break;
            }
            swap(arr, maxPos, i);
            i = maxPos;

        }
    }

    private void swap(int[] arr, int i1, int i2) {
        arr[i1] = arr[i1] ^ arr[i2];
        arr[i2] = arr[i1] ^ arr[i2];
        arr[i1] = arr[i1] ^ arr[i2];
    }

    public String toString() {
        return Arrays.toString(arr);
    }

    public static void main(String[] args) {

        Heap heap = new Heap(8);
        heap.insert(1);
        heap.insert(3);
        heap.insert(5);
        heap.insert(4);
        heap.insert(7);
        heap.insert(9);
//        heap.insert(11);
        heap.insert(7);
        heap.remove();
        System.out.println(heap.toString());

    }

}
