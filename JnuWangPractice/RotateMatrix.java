package com.JnuWangPractice;

public class RotateMatrix {
    /**
     * 旋转矩阵，将矩阵顺时针旋转90度，然后打印，不要使用额外的存储空间
     * 思路：从宏观结构看微观，从矩阵的左上角和右下角元素开始
     * 唯一的难点在于边界的交换
     */

    public static void rotate(int[][] matrix) {
        // 左上角的行数和列数
        int tR = 0, tC = 0;
        // 右下角的行数
        int dR = matrix.length - 1;
        // 右下角的列数
        int dC = matrix[0].length - 1;
         while (tR < dR) {
             rotateEdge(matrix, tR++, tC++, dR--, dC--);
         }
    }

    /**
     * 数组旋转
     * @param matrix
     * @param tR
     * @param tC
     * @param dR
     * @param dC
     */
    public static void rotateEdge(int[][] matrix, int tR, int tC, int dR, int dC) {
        int times = dC - tC;
        int temp = 0;
        for (int i = 0; i != times ; i++) {
            // 注意交换的边界
            temp = matrix[tR][tC + i];
            matrix[tR][tC + i] = matrix[dR - i][tC];
            matrix[dR - i][tC] = matrix[dR][dC - i];
            matrix[dR][dC - i] = matrix[tR + i][dC];
            matrix[tR + i][dC] = temp;
        }
    }

    /**
     * 打印数组
     * @param matrix
     */
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length ; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}};
        printMatrix(matrix);
        rotate(matrix);
        System.out.println("==================");
        printMatrix(matrix);
    }


}
