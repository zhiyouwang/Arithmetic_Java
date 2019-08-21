package com.JnuWangHashMap;

import java.util.HashMap;
import java.util.List;

/**
 * 并查集结构
 * 两个功能：1.非常快的查两个元素是否属于一个集合
 * 2.两个元素各自所在的集合合并到一起
 * 这种结构只接受一次次所有的数据，不接受处理流式的数据
 * 原理：每个元素都有一个指针指向父节点，根节点的父节点是自己，合并的时候将数量少的集合挂在数量多的集合下面，每次查询两
 * 个元素是否属于一个集合的时候，都向上找到根元素，若根元素相同，则属于同一个集合，在查的同时，将查的路途中的节点都打扁
 * 平。这样就能达到非常快的查找速度了
 * 结论：当查询次数 + 合并次数逼近O（N）的时候，那么单次查询的时候复杂度就为O（1）
 */
public class UnionFind {

    public static class Node {
        // 该类型可以随意定义，Int，String，Float...
        // 不需要指针，因为用的是Map结构
    }

    public static class UnionFindSet {
        // Map记录当前元素和父元素
        public HashMap<Node, Node> fatherMap;
        // 记录元素所在集合的元素个数，用来后序进行合并
        public HashMap<Node, Integer> sizeMap;

        public UnionFindSet() {
            fatherMap = new HashMap<Node, Node>();
            sizeMap = new HashMap<Node, Integer>();
        }

        public void makeSets(List<Node> nodes) {
            fatherMap.clear();
            sizeMap.clear();
            for (Node node : nodes) {
                // 初始化每个元素都是根元素
                fatherMap.put(node, node);
                // 每个元素一个集合，大小为1
                sizeMap.put(node, 1);
            }
        }

        /**
         * 递归查找元素的父元素
         * @param node
         * @return
         */
        private Node findHead(Node node) {
            Node father = fatherMap.get(node);
            if (father != node) {
                father = findHead(father);
            }
            fatherMap.put(node, father);
            return father;
        }

        /**
         * 判断两个元素是否属于一个集合
         * @param a
         * @param b
         * @return
         */
        public boolean isSameSet(Node a, Node b) {
            return findHead(a) == findHead(b);
        }

        /**
         * 合并两个元素的集合
         * @param a
         * @param b
         */
        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
            Node aHead = findHead(a);
            Node bHead = findHead(b);
            if (aHead != bHead) {
                int aSetSize = sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);
                if (aSetSize < bSetSize) {
                    fatherMap.put(aHead, bHead);
                    sizeMap.put(bHead, aSetSize + bSetSize);
                } else {
                    fatherMap.put(bHead, aHead);
                    sizeMap.put(aHead, aSetSize + bSetSize);
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
