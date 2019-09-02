package backtracking;

public class Backpack {

    public int maxW = Integer.MIN_VALUE;    //存储背包中物品总重量的最大值

    private boolean[][] mem = new boolean[10][100];   //备忘录，默认false

    /**
     * 假设背包可承受重量100，物品个数10，物品重量存储在数组a中，则这样调用函数
     * f(0, 0, a, 10, 100)
     *
     * @param i     考察到哪个物品了
     * @param cw    当前已经装入的物品重量和
     * @param items 每个物品的重量
     * @param n     物品个数
     * @param w     背包重量
     */
    public void f(int i, int cw, int[] items, int n, int w) {

        if (cw == w || i == n) {  // cw == w 表示装满了； i == n 表示已经考察完所有的物品
            if (cw > maxW)
                maxW = cw;
            return;
        }
        if (mem[i][cw])
            return;
        mem[i][cw] = true;
        f(i + 1, cw, items, n, w);
        if (cw + items[i] <= w) {   //已经超过可以背包承受的重量的时候，就不装了
            f(i + 1, cw + items[i], items, n, w);
        }
    }

    public static void main(String[] args) {

        Backpack backpack = new Backpack();
        backpack.f(0, 0, new int[]{2, 25, 11, 3, 26, 52, 79, 13, 5, 8}, 10, 100);
        System.out.println(backpack.maxW);

    }

}
