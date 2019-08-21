package com.JnuWangTreePractice;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断一颗树是否为搜索二叉树和是否为完全二叉树
 */
public class IsBSTAndCBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 判断是否为搜索二叉树(这里采用的是非递归，看不懂)
     * 思路：1.可以采用递归的方式，中序遍历二叉树，看得到的序列是否为升序，这里主要是对中序遍历的代码进行简单的修改，在
     * 打印的地方进行值的比较。
     * 2、采用非递归方式，摩尔斯遍历（不懂）
     * @param head
     * @return
     */
    public static boolean isBST(Node head) {
        if (head == null) {
            return true;
        }
        boolean res = true;
        Node pre = null;
        Node cur1 = head;
        Node cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                }
            }
            if (pre != null && pre.value > cur1.value) {
                res = false;
            }
            pre = cur1;
            cur1 = cur1.right;
        }
        return res;
    }

    /**
     * 判断是否为完全二叉树
     * 思路：完全二叉树是按照层次来进行遍历的。是否为完全二叉树，这里有两种情况。1.如果一个节点只有右孩子而没有左孩子，
     * 那么它就不是完全二叉树、2，如果一个节点有左孩子而没有右孩子，那么在这个节点之后遍历的所有节点必须都是叶子节点。
     * 这里有个触发条件就是条件2
     * @param head
     * @return
     */
    public static boolean isCBT(Node head) {
        if (head == null) {
            return true;
        }
        Queue<Node> queue = new LinkedList<Node>();
        boolean leaf = false;
        Node left = null;
        Node right = null;
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            left = head.left;
            right = head.right;
            if ((leaf && (left != null || right != null)) || (left == null && right != null)) {
                return false;
            }
            if (left != null) {
                queue.offer(left);
            }
            if (right != null) {
                queue.offer(right);
            } else {
                leaf = true;
            }
        }
        return true;
    }
}
