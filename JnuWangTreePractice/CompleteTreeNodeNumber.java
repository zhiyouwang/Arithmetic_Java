package com.JnuWangTreePractice;

/**
 * 已知一颗完全二叉树，求其节点个数
 * 要求：时间复杂度低于O(N)，N为这颗树的节点个数
 * 时间复杂度：O（（logN）**2）
 * 注：递归的使用情况是，一个问题的子问题和父问题是一样的，这种思想在二叉树的题目中是套路，经常碰到
 */
public class CompleteTreeNodeNumber {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 主函数
     * @param head
     * @return
     */
    public static int nodeNum(Node head) {
        if (head == null) {
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }

    /**
     * 计算当前节点为树的总节点数
     * @param node 当前节点
     * @param level 当前在第几层
     * @param h 树的总高度
     * @return
     */
    public static int bs(Node node, int level, int h) {
        if (level == h) {
            return 1;
        }
        if (mostLeftLevel(node.right, 1 + level) == h) {
            return (1 << (h - level)) + bs(node.right, 1 + level, h);
        } else {
            return (1 << (h - 1 - level)) + bs(node.left, 1 + level, h);
        }
    }

    /**
     * 计算当前节点为树的左子树的高度
     * @param node
     * @param level
     * @return
     */
    public static int mostLeftLevel(Node node, int level) {
        while (node != null) {
            level++;
            node = node.left;
        }
        return level - 1;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        System.out.println(nodeNum(head));

    }
}
