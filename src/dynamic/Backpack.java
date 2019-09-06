package dynamic;

public class Backpack {

    private int[] weight = {2, 2, 4, 6, 3};

    /**
     * @param weight 物品重量
     * @param n      物品个数
     * @param w      背包可承载重量
     */
    public int knapsack(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w + 1];

        states[0][0] = true;    //第一行的数据要特殊处理，可以用哨兵优化
        states[0][weight[0]] = true;

        for (int i = 1; i <= n; ++i) {  //动态规划状态转移

            for (int j = 0; j <= w; ++j) {  //不把第i个物品放入背包
                if (states[i - 1][j])
                    states[i][j] = states[i - 1][j];
            }
            for (int j = 0; j <= w - weight[i]; ++j) {  //把第i个物品放入背包
                if (states[i - 1][j])
                    states[i][j + weight[i]] = true;
            }
        }

        for (int i = w; i >= 0; --i) {  //输出结果
            if (states[n - 1][i])
                return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        Backpack backpack = new Backpack();
        int knapsack = backpack.knapsack(backpack.weight, 5, 9);
        System.out.println(knapsack);
    }

    public int knapsack2(int[] items, int n, int w) {
        boolean[] states = new boolean[w + 1];
        states[0] = true;
        states[items[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = w - items[i]; j >= 0; j--) {   //把第i个物品放入背包
                if (states[j])
                    states[j + items[i]] = true;
            }
        }
        for (int i = w; i >= 0; i--) {
            if (states[i])
                return i;
        }
        return 0;
    }



}
