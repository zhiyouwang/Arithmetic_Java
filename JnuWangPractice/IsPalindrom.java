package com.JnuWangPractice;

public class IsPalindrom {
    /**
     * 判断链表是否为回文
     * 共有3中解法：
     * 1、将链表所有的值全部入栈，然后重新遍历相比对
     * 2、利用快慢指针找到中点，将后一部分入栈，然后遍历
     * 3、利用快慢指针，将链表后一部分反转，从链表两头开始向中间遍历
     */

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isPalindrom(Node head) {
        if (head == null || head.next == null) return true;
        Node low = head;
        Node high = head;
        // 快慢指针找到中点
        while (high.next != null && high.next.next != null) {
            low = low.next;
            high = high.next.next;
        }
        // 快指针指向右部分的第一个节点
        high = low.next;
        low.next = null;
        Node node = null;
        // 右部分反转
        while (high != null) {
            node = high.next;
            high.next = low;
            low = high;
            high = node;
        }
        // 保存最后一个节点
        node = low;
        // 保存第一个节点
        high = head;
        boolean res = true;
        // 检查是否为回文
        while (low != null && high != null) {
            if (low.value != high.value) {
                res = false;
                break;
            }
            low = low.next;
            high = high.next;
        }
        low = node.next;
        node.next = null;
        // 链表反转成原样
        while (low != null) {
            high = low.next;
            low.next = node;
            node = low;
            low = high;
        }
        return res;
    }
}
