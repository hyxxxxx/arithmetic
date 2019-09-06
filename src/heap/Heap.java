package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

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

    private static void buildHeap(int[] arr, int size) {
        for (int i = size / 2; i >= 1; --i) {
            heapify(arr, size, i);
        }
    }

    /**
     * @param arr  堆数组
     * @param size 堆大小
     * @param i    待放置的元素下标
     */
    private static void heapify(int[] arr, int size, int i) {
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

    /**
     * 首先将待排序数组堆化 buildHeap()
     * 每次把对顶元素（max）与最后一个元素交换
     * 然后将剩余元素堆化
     * 直到只剩最后一个元素
     *
     * @param arr  待排数组
     * @param size 数组大小
     */
    public static void sort(int[] arr, int size) {
        buildHeap(arr, size);
        int i = size;
        while (i > 1) {
            swap(arr, 1, size);
            --i;
            heapify(arr, size, i);
        }
    }

    private static void swap(int[] arr, int i1, int i2) {
        arr[i1] = arr[i1] ^ arr[i2];
        arr[i2] = arr[i1] ^ arr[i2];
        arr[i1] = arr[i1] ^ arr[i2];
    }

    public String toString() {
        return Arrays.toString(arr);
    }

    public static void main(String[] args) {

//        Heap heap = new Heap(8);
//        heap.insert(1);
//        heap.insert(3);
//        heap.insert(5);
//        heap.insert(4);
//        heap.insert(7);
//        heap.insert(9);
//        heap.insert(11);
//        heap.insert(7);
//        heap.remove();
        int[] ints = {0, 1, 12, 33, 55, 6, 5, 7};
        Heap.sort(ints, 7);
        System.out.println(Arrays.toString(ints));

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(2);
        queue.offer(5);
        queue.offer(3);
        queue.offer(1);
        queue.offer(4);
    }

}
