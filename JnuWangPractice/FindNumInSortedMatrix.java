package com.JnuWangPractice;

public class FindNumInSortedMatrix {
    /**
     * 在排好序的数组中找一个数，该数组从左到右和从上到下都是排好序的
     * 思路：1、看数据的状况，2、看问的问题
     */

    public static boolean isContains(int[][] matrix, int num) {
        // 从右上角开始
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix[row][col] && row <= matrix.length - 1 && col >= 0) {
            if (matrix[row][col] == num) {
                return true;
            } else if (matrix[row][col] > num) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 0, 1, 2, 3, 4, 5, 6 },// 0
                { 10, 12, 13, 15, 16, 17, 18 },// 1
                { 23, 24, 25, 26, 27, 28, 29 },// 2
                { 44, 45, 46, 47, 48, 49, 50 },// 3
                { 65, 66, 67, 68, 69, 70, 71 },// 4
                { 96, 97, 98, 99, 100, 111, 122 },// 5
                { 166, 176, 186, 187, 190, 195, 200 },// 6
                { 233, 243, 321, 341, 356, 370, 380 } // 7
        };
        int num = 233;
        System.out.println(isContains(matrix, num));
    }
}
