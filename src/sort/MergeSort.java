package sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {


    public static void main(String[] args) {

        int[] array = SortSample.generateRandomArray();

        MergeSort sort = new MergeSort();
        sort.mergeSort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));

    }

    public void mergeSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        //将数组分段，拆解成子任务
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);

        merge(arr, l, mid, r);
    }

    private void merge(int[] arr, int l, int mid, int r) {
        int[] tmp = new int[r - l + 1];
        int i = 0;
        int p = l;
        int q = mid + 1;

        //依次比较两段有序值，按顺序放入tmp
        while (p <= mid && q <= r) {
            if (arr[p] > arr[q]) {
                tmp[i++] = arr[q++];
            } else {
                tmp[i++] = arr[p++];
            }
        }
        //将左边剩余值放入tmp
        while (p <= mid) {
            tmp[i++] = arr[p++];
        }
        //将右边剩余值放入tmp
        while (q <= r) {
            tmp[i++] = arr[q++];
        }

        //将排好序的tmp值替换原arr的值
        for (i = 0; i < tmp.length; i++) {
            arr[l + i] = tmp[i];
        }

    }

    public int[] merge(int[] i1, int[] i2) {

        int[] tmp = new int[i1.length + i2.length];
        int p = 0;
        int q = 0;
        int i = 0;
        while (p < i1.length && q < i2.length) {
            if (i1[p] > i2[q]) {
                tmp[i++] = i2[q++];
            } else {
                tmp[i++] = i1[p++];
            }
        }
        if (p == i1.length) {
            for (int j = q; j < i2.length; j++, i++) {
                tmp[i] = i2[j];
            }
        } else {
            for (int j = p; j < i1.length; j++, i++) {
                tmp[i] = i1[j];
            }
        }
        return tmp;
    }

}
