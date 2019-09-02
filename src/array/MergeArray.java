package array;

public class MergeArray {

    public static void main(String[] args) {

        int[] a = {2, 6, 8, 9, 15, 22, 68, 98, 102, 236};

        int[] b = {1, 4, 6, 7, 9, 11, 13, 14, 95, 206, 333, 654};

        MergeArray mergeArray = new MergeArray();
        int[] arr = mergeArray.merge(a, b);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }

    }

    public int[] merge(int[] a, int[] b) {
        int[] arr = new int[a.length + b.length];
        int point = 0;
        int ap = 0;
        int bp = 0;
        while (point <= a.length - 1 || point <= b.length - 1) {

            if (a[ap] > b[bp]) {
                arr[point++] = b[bp++];
            } else {
                arr[point++] = a[ap++];
            }

            if (ap == a.length - 1) {
                System.arraycopy(b, bp, arr, point, b.length - bp);
            }
            if (bp == b.length - 1) {
                System.arraycopy(a, ap, arr, point, a.length - ap);
            }

        }
        return arr;
    }


}
