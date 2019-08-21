package com.JnuWangTreePractice;

/**
 * 题：把纸条竖着放在桌子上，然后从纸条的现编向上方对折，压出折痕后再展开，此时有一条折痕，突起的方向指向纸条的背面，这
 * 条折痕叫做“下”折痕；突起的方向指向纸条正面的折痕叫做“上”折痕。如果每次都从下边向上方对折，对折N次，请从上到下计算
 * 出所有的折痕的方向。
 * 思路：这相当于是一道二叉树树的构建，每次对折都会出现双倍的节点，因此是二叉树，这颗二叉树.每个节点的左节点是下折痕，
 * 右节点是上折痕。(注意：第一次的折痕为根节点，根节点的左右孩子节点为下一次折叠的两个折痕，在折叠多次后，它们并不是相邻
 * 的)
 */
public class PaperFolding {

    public static void printAllFolds(int N) {
        printProcess(1, N, true);
    }

    public static void printProcess(int i, int N, boolean down) {
        if (i > N) {
            return;
        }
        printProcess(i + 1, N, true);
        System.out.println(down ? "down" : "up");
        printProcess(i + 1, N, false);
    }

    public static void main(String[] args) {
        int N = 3;
        printAllFolds(N);
    }
}
