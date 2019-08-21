package com.JnuWangSwordOffer;

/**
 * 题目：输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树，假设输入的前序遍历和中序遍历的结果中都不包含重复的数组，
 * 例如：输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历{4,7,2,1,5,3,8,6}，则重建二叉树并输出它的头结点
 * 思路：遇到这样的问题首先从正常的思路入手，给出一颗二叉树的先序序列和中序序列能够唯一的确定一颗二叉树。根据先序遍历和
 * 中序遍历的特点来进行二叉树的重建，先序序列的第一个元素肯定是二叉树的根节点，根据根节点在中序序列中能够查找出根节点的
 * 左孩子和右孩子。同时在先序序列中也能够找到相对应的左子树和右子树，这样就是一个递归的过程，分析完成这个过程之后就能够
 * 很容易的理清重建二叉树的过程逻辑了。
 */
public class BinaryTreeConstruct {

    public static class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }
    }

    public static BinaryTreeNode constructBinaryTree(int[] pre, int[] in) {
        BinaryTreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    public static BinaryTreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) return null;
        BinaryTreeNode root = new BinaryTreeNode(pre[startPre]);
        for (int i = startIn; i < endIn; i++) {
            if (in[i] == pre[startPre]) {
                root.left = reConstructBinaryTree(pre,startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] pre = new int[] {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = new int[] {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode node = constructBinaryTree(pre, in);
        System.out.print(node.value + " ");
    }
}
