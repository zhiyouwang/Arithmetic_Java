package com.JnuWangGreedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 题：一块金条切成两半，是需要花费和长度数值一样的铜板的。比如长度为20的金条，不管切成长度多大的两半，都要花费20个铜板。
 * 一群人想整分整块金条，怎么分最省铜板？
 * 例如：给定数组[10, 20, 30],代表一共三个人，整块金条长度为10 + 20 + 30 = 60，金条要分成10， 20, 30三个部分。如果，先把
 * 长度60的金条分成10和50，花费60，再把长度50的金条分成20和30，花费50，一共花费110铜板
 * 但是如果，先把长度60的金条分成30和30，花费60，再把长度30的金条分成10和30，花费30，一共花费90铜板，
 * 输入一个数组，返回分割的最小代价
 *
 * 思路：这也是一个贪心算法的题，根据所学的知识进行题目的分析，发现这就是哈夫曼树，我们从下往上进行思考，然后从上往下进
 * 行分割，也就是每次都找出两个最小的值出来，构造一颗哈夫曼树。
 *
 * 因此，这里要使用到堆来进行贪心，注意：堆是一种非常好的结构，它对于贪心的这种使用由很大的作用，这取决于堆的结构，每次
 * 都能找出一堆树中的最小值或者最大值。要学会使用堆。
 */
public class LessMoney {

    public static int lessMoney(int[] arr) {
        // 当不指定比较器Comparator时，默认是最小堆
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        // 加入堆中
        for (int i = 0; i < arr.length; i++) {
            pQ.add(arr[i]);
        }
        int sum = 0;
        int cur = 0;
        while (pQ.size() > 1) {
            cur = pQ.poll() + pQ.poll();
            sum += cur;
            pQ.add(cur);
        }
        return sum;
    }

    /**
     * 小根堆
     */
    public static class MinheapComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }

    /**
     * 大根堆
     */
    public static class MaxheapComparator implements  Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    public static void main(String[] args) {

        int[] arr = { 10, 20, 30 };
        System.out.println(lessMoney(arr));

        int[] arrForHeap = { 3, 5, 2, 7, 0, 1, 6, 4 };

        // min heap
        PriorityQueue<Integer> minQ1 = new PriorityQueue<>();
        for (int i = 0; i < arrForHeap.length; i++) {
            minQ1.add(arrForHeap[i]);
        }
        while (!minQ1.isEmpty()) {
            System.out.print(minQ1.poll() + " ");
        }
        System.out.println();

        // min heap use Comparator
        PriorityQueue<Integer> minQ2 = new PriorityQueue<>(new MinheapComparator());
        for (int i = 0; i < arrForHeap.length; i++) {
            minQ2.add(arrForHeap[i]);
        }
        while (!minQ2.isEmpty()) {
            System.out.print(minQ2.poll() + " ");
        }
        System.out.println();

        // max heap use Comparator
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(new MaxheapComparator());
        for (int i = 0; i < arrForHeap.length; i++) {
            maxQ.add(arrForHeap[i]);
        }
        while (!maxQ.isEmpty()) {
            System.out.print(maxQ.poll() + " ");
        }
    }
}
