package com.JnuWangGreedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 题目：有几个项目，分别有做项目需要花费的金钱数，和做该项目所得的利润。还有初始资金，和能做的最大项目的个数，问怎么做
 * 项目会得到最大的收益,返回最大的收益值
 *
 * 思路：在有项目个数限制的情况下，要想获得的总收益最大，常规的想法就是做某个项目，花的钱少，获得的利润多，因此，可以分
 * 别对项目的花费和收益进行小根堆和大根堆的处理，小根堆用来筛选做项目所需要花费的金钱，大根堆用来筛选所获得的最大利润。
 * 这样就可以找出最佳的项目了
 *
 */
public class IPO {

    /**
     * d定义每个项目的结构
     */
    public static class Node {
        // 项目的利润
        public int p;
        // 项目的花费
        public int c;

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    /**
     * 定义小根堆，用来筛选项目的最小花费
     */
    public static class MinCostComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }
    }

    /**
     * 定义大根堆，用来筛选最大利润
     */
    public static class MaxProfitComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }
    }

    /**
     * 找出最大的收益
     * @param k 项目的个数
     * @param w 初始资金
     * @param profits 利润数组
     * @param capital 花费数组
     * @return 最大收益
     */
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Node[] nodes = new Node[profits.length];
        for (int i = 0; i < profits.length; i++) {
            nodes[i] = new Node(profits[i], capital[i]);
        }

        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxPriftQ = new PriorityQueue<>(new MaxProfitComparator());
        // 将所有的项目放进小根堆
        for (int i = 0; i < nodes.length; i++) {
            minCostQ.add(nodes[i]);
        }
        // 最多做k个项目
        for (int i = 0; i < k; i++) {
            // 筛选小根堆符合要求项目放入大根堆
            while (!minCostQ.isEmpty() && minCostQ.peek().c < w) {
                maxPriftQ.add(minCostQ.poll());
            }
            // 如果大根堆没有项目，则表示项目已经没有符合要求的项目了
            if (maxPriftQ.isEmpty()) {
                return w;
            }
            w += maxPriftQ.poll().p;
        }
        return w;
    }
}
