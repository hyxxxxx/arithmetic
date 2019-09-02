public class Arrays {

    /**
     * 基础二分查找
     *
     * @param a   数组
     * @param n   数组长度
     * @param val 要寻找的值
     * @return 返回查找值下标，未找到返回-1
     */
    public static int binarySearch(int[] a, int n, int val) {

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;   //中间下标
            if (a[mid] == val) {
                return mid;
            } else if (a[mid] > val) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个值等于val的元素
     */
    public static int bsFirstVal(int[] a, int n, int val) {

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;   //中间下标

            if (a[mid] > val) {
                high = mid - 1;
            } else if (a[mid] < val) {
                low = mid + 1;
            } else {
                if ((mid == 0) || (a[mid - 1] != val))
                    return mid;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于val的元素
     */
    public static int bsLastVal(int[] a, int n, int val) {

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;   //中间下标
            if (a[mid] > val) {
                high = mid - 1;
            } else if (a[mid] < val) {
                low = mid + 1;
            } else {
                if ((mid == n - 1) || (a[mid + 1] != val))
                    return mid;
                else
                    low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个值大于等于val的元素
     */
    public static int bsFirstGteVal(int[] a, int n, int val) {

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;   //中间下标

            if (a[mid] >= val) {
                if ((mid == 0) || (a[mid - 1] < val))
                    return mid;
                else
                    high = mid - 1;
            } else
                low = mid + 1;
        }
        return -1;
    }

    /**
     * 查找最后一个值小于等于val的元素
     */
    public static int bsLastLteVal(int[] a, int n, int val) {

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;   //中间下标

            if (a[mid] > val) {
                high = mid - 1;
            } else {
                if ((mid == n - 1) || (a[mid + 1] > val))
                    return mid;
                else
                    low = mid + 1;
            }
        }
        return -1;
    }

}
