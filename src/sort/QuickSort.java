package sort;

import java.util.Arrays;

public class QuickSort {

    public void quickSort() {

        int[] array = SortSample.generateRandomArray();
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

    }

    private void quickSort(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = partition(arr, p, r);   //获取分区点
        quickSort(arr, p, q - 1);
        quickSort(arr, q + 1, r);
    }

    /**
     * @param arr 待排数组
     * @param p   开始下标
     * @param r   结束下标
     * @return 分区点
     */
    private int partition(int[] arr, int p, int r) {
        int pivot = arr[r]; //将最后一个元素作为pivot
        int i = p;
        for (int j = p; j <= r - 1; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);    //如果比pivot小，则交换两数位置
                i++;
            }
        }
        //将pivot放在分区中间
        //左边是小于pivot的
        //右边是大于pivot的
        swap(arr, i, r);
        return i;
    }

    private void swap(int[] arr, int a, int b) {
        if (a == b) {
            return;
        }
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }

    public static void main(String[] args) {

        new QuickSort().quickSort();

    }

}
