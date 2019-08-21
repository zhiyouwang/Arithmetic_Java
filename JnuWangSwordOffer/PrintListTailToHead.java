package com.JnuWangSwordOffer;

import java.util.Stack;

/**
 * 从尾到头打印链表
 * 题目：输入一个链表的头结点，从尾结点反过来打印出每个节点的值
 * 思路：1.先将链表反转，再对链表进行遍历（这样做的缺点是会改变链表的结构）
 * 2.顺序遍历，将遍历的数据放入到栈中，遍历结束后再取栈中数据遍历（缺点是会有额外空间）
 */
public class PrintListTailToHead {

    public static class ListNode {
        public int value;
         public ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    public static void printListTailToHead (ListNode head) {
        ListNode pNode = head;
        Stack<Integer> stack = new Stack<>();
        while (pNode != null) {
            stack.push(pNode.value);
            pNode = pNode.next;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + "->");
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        printListTailToHead(head);
    }
}
