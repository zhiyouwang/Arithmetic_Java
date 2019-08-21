package com.JnuWangHashMap;

/**
 * 有一个二维矩阵，所有1连在一起的位一个岛，求整个矩阵有多少个岛
 * 思路：如果遇到1，就将1连着的所有1都变成2，之后每遍历到一个1，就将其变成2，并且岛的数量加1
 * 拓展：上面的思路是基于单核但CPU进行的操作，但是当这个矩阵特别大的时候，就可以用到多个机器进行处理了，然而在用多个机器
 * 进行处理的时候，岛的数量会增加，这是就需要对岛的边界进行收集计算，这时，收集边界的元素的感染中心，当进行边界合并时，
 * 就可以用到并查集结构了，查询其两个感染中心是否相同。如果相同，就将岛的的数量减一。这样就可以进行边界信息合并了。
 * 记住并查集的结构
 */
public class Islands {
    /**
     * 计算岛的数量
     * @param m
     * @return
     */
    public static int countIslands(int[][] m) {
        if (m == null || m[0] == null) {
            return 0;
        }
        int row = m.length;
        int colum = m[0].length;
        int land = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colum; j++) {
                if (m[i][j] == 1) {
                    land++;
                    infect(m, i, j, row, colum);
                }
            }
        }
        return land;
    }

    /**
     * 感染函数
     * 因为首先会判断是否等于1，所以运行的速度是比较快的
     * @param m
     * @param i
     * @param j
     * @param row
     * @param colum
     */

    public static void infect(int[][] m, int i, int j, int row, int colum) {
        if (i < 0 || i > row || j < 0 || j > colum || m[i][j] != 1) {
            return;
        }
        m[i][j] = 2;
        // 感染下
        infect(m, i + 1, j, row, colum);
        // 感染右
        infect(m, i, j + 1, row, colum);
        // 感染上
        infect(m, i - 1, j, row, colum);
        // 感染左
        infect(m, i, j - 1, row, colum);
    }

    public static void main(String[] args) {
        int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(countIslands(m1));

        int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(countIslands(m2));

    }
}
