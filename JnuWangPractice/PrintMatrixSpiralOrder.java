package com.JnuWangPractice;

public class PrintMatrixSpiralOrder {
    /**
     * 螺旋打印二维数组
     * 思路：同样是从宏观找微观
     * 每次都打印外圈，然后每次把数组缩小
     */
    public static void spiralOrderPrint(int[][] matrix) {
        // 左上角的行和列
        int tR = 0,tC = 0;
        // 右下角的行和列
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <= dR && tC <= dC) {
            printEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }

    private static void printEdge(int[][] matrix, int tR, int tC, int dR, int dC) {
        if (tR == dR) {// 只有一行
            for (int i = tC; i <= dC; i++) {
                System.out.print(matrix[tR][i] + " ");
            }
        } else if (tC == dC) {// 只有一列
            for (int i = tR; i <= dR; i++) {
                System.out.print(matrix[i][tC]);
            }
        } else {
            int curC = tC;
            int curR = tR;
            // 打印行
            while (curC != dC) {
                System.out.print(matrix[tR][curC] + " ");
                curC++;
            }
            // 打印列
            while (curR != dR) {
                System.out.print(matrix[curR][dC] + " ");
                curR++;
            }
            // 从右往左打印行
            while (curC != tC) {
                System.out.print(matrix[dR][curC] + " ");
                curC--;
            }
            // 从下往上打印列
            while (curR != tR) {
                System.out.print(matrix[curR][tC] + " ");
                curR--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        spiralOrderPrint(matrix);
    }
}
