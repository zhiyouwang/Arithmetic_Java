package com.JnuWangPractice;

public class FindFirstIntersectNode {
    /**
     * 题目：两个单链表相交的问题
     * 单链表可能有环，也可能无环。给定两个单链表的头结点head1和head2，这两个链表可能相交，也可能不相交，请实现一个函数，
     * 如果两个链表相交，请返回相交的第一个节点；如果不相交，返回null。要求，如果链表1的长度为N，链表2的长度为M，时间复
     * 杂度请达到O（M+N），额外空间复杂度请达到O（1）
     * 思路：要考虑两点，1、对于两个链表。首先要判断出其是否有环。2、怎么判断两个无环单链表相交的节点
     * 综合考虑：公有三种情况，1）各自成环，不想交。2）相交，共享一个环。3）有两个入环节点，共享一个环.4）不成环，Y字型
     * 判断链表是否有环：1）HashSet。2）快慢指针（结论）
     */
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 主功能函数
     * @param head1
     * @param head2
     * @return
     */
    public static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) return null;
        // 分别找到两个链表的环的入口节点
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        // 两个都没环
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        // 都有环
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }

    /**
     * 都有环
     * @param head1
     * @param loop1
     * @param head2
     * @param loop2
     * @return
     */
    private static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 = null;
        Node cur2 = null;
        // 共享一个环
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            // n是记录两个链表的长度差
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            // 有环不想交
            return null;
        }
    }

    /**
     * 无环
     * @param head1
     * @param head2
     * @return
     */
    private static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) return null;
        Node cur1 = head1;
        Node cur2 = head2;
        // n是标记两个链表的长度之差
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        // 长链表先走n步
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return  cur1;
    }

    /**
     * 得到入环的节点(这是一个结论，经历过数学证明，记住即可)
     * @param head
     * @return
     */
    private static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) return null;
        Node n1 = head.next;// slow
        Node n2 = head.next.next;// fast
        while (n1 != n2) {
            if (n2.next == null || n2.next.next == null) {
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head;// walk again from head
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);
    }

}
