package com.JnuWangPractice;

public class PrintMatrixZigZag {
    /**
     * 之字形打印二维数组
     * 解决方案：宏观调度
     */

    public static void printMatrixZigZag(int[][] matrix) {
        // 横向的行和列
        int tR = 0, tC = 0;
        // 纵向的行和列
        int dR = 0, dC = 0;
        // 数组行的长度
        int endR = matrix.length - 1;
        // 数组列的长度
        int endC = matrix[0].length - 1;
        // 布尔类型判断是否变向
        boolean fromUp = false;
        // tR走到了最后一行，循环停止，因为横向走到末尾就是向下走
        while (tR != endR + 1) {
            printLevel(matrix, tR, tC, dR, dC, fromUp);
            tR = tC == endC ? tR + 1 : tR;
            tC = tC == endC ? tC : tC + 1;
            dC = dR == endR ? dC + 1 : dC;
            dR = dR == endR ? dR : dR + 1;
            fromUp = !fromUp;
        }
        System.out.println();
    }

    /**
     * 根据两个坐标打印
     * @param matrix
     * @param tR
     * @param tC
     * @param dR
     * @param dC
     * @param fromUp
     */
    private static void printLevel(int[][] matrix, int tR, int tC, int dR, int dC, boolean fromUp) {
        if (fromUp) {
            while (tR != dR + 1) {
                System.out.print(matrix[tR++][tC--] + " ");
            }
        } else {
            while (dR != tR - 1) {
                System.out.print(matrix[dR--][dC++] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 } };
        printMatrixZigZag(matrix);
    }
}
