package com.JnuWangTreePractice;

import java.util.Stack;

/**
 * 树的遍历，树的遍历在之前数据结构里已经进行了练习，这里再次练习，增强理解，尤其注意后序遍历的实现
 */
public class PreInPosTraversal {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 关于递归，首先要理解的是，递归在访问节点的过程中，每个节点都会访问三次，那么先序，中序和后序三种遍历的方式就是分
     * 别对应了节点遍历三个位置
     */
    /**
     * 递归实现先序遍历
     * @param head
     */
    public static void preOrderRecur(Node head) {
        if (head == null) return;
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    /**
     * 中序遍历递归实现
     * @param head
     */
    public static void inOrderRecur(Node head) {
        if (head == null) return;
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    /**
     * 后序遍历递归实现
     * @param head
     */
    public static void posOrderRecur(Node head) {
        if (head == null) return;
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

    /**
     * 先序遍历非递归实现
     * @param head
     */
    public static void preOrderUnRecur(Node head) {
        System.out.print("Pre Order : ");
        if (head != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.value + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    /**
     * 中序遍历非递归实现
     * @param head
     */
    public static void inOrderUnRecur(Node head) {
        System.out.print("in order : ");
        if (head != null) {
            Stack<Node> stack = new Stack<Node>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    /**
     * 后序遍历非递归(两个栈实现)
     * @param head
     */
    public static void posOrderUnRecur1(Node head) {
        System.out.print("pos-order : ");
        if (head != null) {
            Stack<Node> stack1 = new Stack<Node>();
            Stack<Node> stack2 = new Stack<Node>();
            stack1.push(head);
            while (!stack1.isEmpty()) {
                head = stack1.pop();
                stack2.push(head);
                if (head.left != null) {
                    stack1.push(head.left);
                }
                if (head.right != null) {
                    stack1.push(head.right);
                }
            }
            while (!stack2.isEmpty()) {
                System.out.print(stack2.pop().value + " ");
            }
        }
        System.out.println();
    }

    /**
     * 用一个栈来实现后序遍历
     * @param head
     */
    public static void posOrderUnRecur2(Node head) {
        System.out.print("pos-order : ");
        if (head != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.push(head);
            Node node = null;
            while (!stack.isEmpty()) {
                node = stack.peek();
                if (node.left != null && head != node.left && head != node.right) {
                    stack.push(node.left);
                } else if (node.right != null && head != node.right) {
                    stack.push(node.right);
                } else {
                    System.out.print(stack.pop().value + " ");
                    head = node;
                }
            }
        System.out.println();
        }
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        posOrderRecur(head);
        System.out.println();

        // unrecursive
        System.out.println("============unrecursive=============");
        preOrderUnRecur(head);
        inOrderUnRecur(head);
        posOrderUnRecur1(head);
        posOrderUnRecur2(head);

    }
}
