package backtracking;

public class Queens8 {

    private int[] result = new int[8];  //下标表示行，值表示queen存储在哪一列

    public static void main(String[] args) {

//        Queens8 queens8 = new Queens8();
//        queens8.cal8queens(0);

        System.out.println(Integer.MIN_VALUE);

    }

    public void cal8queens(int row) {

        if (row == 8) { //8个棋子都放置好了，打印结果
            printQueens(result);
            return;
        }
        for (int column = 0; column < 8; ++column) {    //每一行中都有8种放法
            if (isOk(row, column)) {    //检查放置是否满足要求
                result[row] = column;   //第row行的棋子放到了column列
                cal8queens(row + 1);    //继续放下一行
            }
        }

    }

    private boolean isOk(int row, int column) { //判断row行column列放置是否合适
        int leftUp = column - 1, rightUp = column + 1;
        for (int i = row - 1; i >= 0; --i) {    //逐行往上考察每一行
            if (result[i] == column)
                return false;   //第i行的column列有棋子
            if (leftUp >= 0) {  //考察左上对角线
                if (result[i] == leftUp)
                    return false;   //第i行leftUp列有棋子
            }
            if (rightUp < 8) {  //考察右上对角线
                if (result[i] == rightUp)
                    return false;   //第i行rightUp列有棋子
            }
            --leftUp;
            ++rightUp;
        }
        return true;
    }

    private void printQueens(int[] result) {
        for (int row = 0; row < 8; ++row) {
            for (int column = 0; column < 8; ++column) {
                if (result[row] == column)
                    System.out.print("Q ");
                else
                    System.out.print("* ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
