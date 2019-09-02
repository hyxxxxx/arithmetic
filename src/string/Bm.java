package string;

public class Bm {

    private static final int SIZE = 256;


    public static void main(String[] args) {
        String a = "aaabaaabaaabaaab";
        String b = "aaaa";
        int bm = bm(a.toCharArray(), a.length(), b.toCharArray(), b.length());
        System.out.println(bm);
    }

    /**
     * 将模式串中的每个字符及其下标都存到散列表bc中
     * 这样可以快速找到坏字符在模式串中的位置下标了
     *
     * @param b  模式串
     * @param m  模式串长度
     * @param bc 模式串对应的散列数组
     */
    private static void generateBC(char[] b, int m, int[] bc) {
        for (int i = 0; i < SIZE; ++i) {
            bc[i] = -1; //初始化bc
        }
        for (int i = 0; i < m; i++) {
            int ascii = (int) b[i];  //计算b[i]的ASCII值
            bc[ascii] = i;
        }
    }

    private static void generateBC(char[] b, int m, int[] suffix, boolean[] prefix) {
        for (int i = 0; i < m; ++i) {   //初始化
            suffix[i] = -1;
            prefix[i] = false;
        }
        for (int i = 0; i < m - 1; ++i) {
            int j = i;
            int k = 0;  //公共后缀子串长度
            while (j >= 0 && b[j] == b[m - 1 - k]) {    //与b[0,m-1]求公共后缀子串
                --j;
                ++k;
                suffix[k] = j + 1;    //j+1 表示公共后缀子串在 b[0,i] 中的起始下标
            }
            if (j == -1) {
                prefix[k] = true;   //公共后缀子串也是模式串的前缀子串
            }
        }

    }

    public static int bm(char[] a, int n, char[] b, int m) {
        int[] bc = new int[SIZE];   //记录模式串中每个字符最后出现的位置
        generateBC(b, m, bc);       //构建坏字符哈希表
        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        generateBC(b, m, suffix, prefix);
        int i = 0;  //i表示主串与模式串对其的第一个字符
        while (i <= n - m) {
            int j;
            for (j = m - 1; j >= 0; --j) {  //模式串从后往前匹配
                if (a[i + j] != b[j])   //坏字符对应模式串中的下标是 j
                    break;
            }
            if (j < 0) {
                return i;   //匹配成功，返回主串与模式串中第一个匹配的字符的位置
            }

            int x = j - bc[(int) a[i + j]];
            int y = 0;
            if (j < m - 1) {    //如果有好后缀的话
                y = moveByGS(j, m, suffix, prefix);
            }

            i = i + Math.max(x, y);
        }
        return -1;  //未找到返回-1
    }

    private static int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
        int k = m - 1 - j;  //好后缀长度
        if (suffix[k] != -1) {
            return j - suffix[k] + 1;
        }
        for (int r = j + 2; r <= m - 1; ++r) {
            if (prefix[m - r]) {
                return r;
            }
        }
        return m;
    }


}
