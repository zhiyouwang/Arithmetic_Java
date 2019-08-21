package com.JnuWangTreePractice;

/**
 * 判断一颗二叉树是否为平衡二叉树
 * 思路：类型树形的题目，要了解解题的套路，因为二叉树额结构很固定，非常适合使用递归来解决，
 * 大部分都是根节点->左子树->右子树这样的一个套路，其实这也是一个动态规划的问题
 * 其主要问题就是要列出可能出现的可能性，将可能性列出来以后，问题就简答很多了
 * 对于本题而言，判断一棵树是否为平衡二叉树，从根节点起，
 * 主要有4种可能性，1，节点的左子树不是平衡二叉树，2，节点的右子树不是平衡二叉树，3，左子树的高度与右子树的高度差大于1，
 * 4，根节点为空
 */
public class IsBlancedTree {

    public static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    /**
     * 自定义的递归返回结构
     */
    public static class ReturnNode {
        boolean isB;
        int h;

        public ReturnNode(boolean isB, int h) {
            this.h = h;
            this.isB = isB;
        }
    }

    /**
     * 递归主函数
     * @param head
     * @return
     */
    public static boolean isBalance(TreeNode head) {
        return process(head).isB;
    }

    /**
     * 递归过程
     * @param head
     * @return
     */
    public static ReturnNode process(TreeNode head) {
        if (head == null) {
            return new ReturnNode(true, 0);
        }
        ReturnNode leftData = process(head.left);
        if (!leftData.isB) {
            return new ReturnNode(false, 0);
        }
        ReturnNode rightData = process(head.right);
        if (!rightData.isB) {
            return new ReturnNode(false, 0);
        }
        if (Math.abs(leftData.h - rightData.h) > 1) {
            return new ReturnNode(false, 0);
        }
        return new ReturnNode(true, Math.max(leftData.h, rightData.h) + 1);
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);

        System.out.println(isBalance(head));
    }
}
