package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BucketSort {

    public static void main(String[] args) {

        int[] array = new int[100000];
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            array[i] = random.nextInt(1000000);
        }

        BucketSort sort = new BucketSort();
        sort.sort(array);

        print(array);
    }

    public void sort(int[] array) {

        // 确定元素的最值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            max = Math.max(max, array[i]);
            min = Math.min(min, array[i]);
        }

        // 桶数：(max - min) / array.length的结果为数组大小的倍数（最大倍数），以倍数作为桶数
        int bucketNum = (max - min) / array.length + 1;
        // 初始化桶
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<>());
        }

        // 将每个元素放入桶
        for (int i = 0; i < array.length; i++) {
            // 计算每个(array[i] - min)是数组大小的多少倍，看看放入哪个桶里
            int num = (array[i] - min) / (array.length);
            bucketArr.get(num).add(array[i]);
        }

        // 对每个桶进行排序
        for (int i = 0; i < bucketArr.size(); i++) {
            Collections.sort(bucketArr.get(i));
        }

        // 合并数据
        int j = 0;
        for (ArrayList<Integer> tempList : bucketArr) {
            for (int i : tempList) {
                array[j++] = i;
            }
        }
    }

    /**
     * 打印数组
     */
    public static void print(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
