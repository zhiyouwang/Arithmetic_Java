package com.JnuWangTreePractice;

/**
 * 前缀树
 * 这种数据结构可用作处理字符串的问题，是非常经典的一个结构，结构灵活
 */
public class TrieTree {

    /**
     * 节点的结构
     */
    public static class TrieNode {
        // 这个点划过多少次
        public int path;
        // 以这个节点为结尾的个数
        public int end;
        // 定义每个节点的分支数，分支主要作用是放置字符信息
        public TrieNode[] nexts;

        public TrieNode() {
            path = 0;
            end = 0;
            // 这里定义为26个英文字母
            nexts = new TrieNode[26];
        }
    }

    public static class Trie {
        private TrieNode root;

        // 初始化根节点，无任何信息，空节点
        public Trie() {
            root = new TrieNode();
        }

        /**
         * 插入字符串
         * @param word
         */
        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            // 该字符应该在哪个分支
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.path++;
            }
            node.end++;
        }

        /**
         * 删除word
         * @param word
         */
        public void delete(String word) {
            if (search(word) != 0) {
                char[] chs = word.toCharArray();
                TrieNode node = root;
                int index = 0;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i] - 'a';
                    if (--node.nexts[index].path == 0) {
                        node.nexts[index] = null;
                        // 如果发现当前path为0，则在他之后就不用判断了
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }

        /**
         * word插入多少次
         * @param word
         * @return
         */
        public int search(String word) {
            if (word == null) {
                return 0;
            }
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        /**
         * 以pre为前缀的字符串有多少个
         * @param pre
         * @return
         */
        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] chs = pre.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.path;
        }

        public static void main(String[] args) {
            Trie trie = new Trie();
            System.out.println(trie.search("zuo"));
            trie.insert("zuo");
            System.out.println(trie.search("zuo"));
            trie.delete("zuo");
            System.out.println(trie.search("zuo"));
            trie.insert("zuo");
            trie.insert("zuo");
            trie.delete("zuo");
            System.out.println(trie.search("zuo"));
            trie.delete("zuo");
            System.out.println(trie.search("zuo"));
            trie.insert("zuoa");
            trie.insert("zuoac");
            trie.insert("zuoab");
            trie.insert("zuoad");
            trie.delete("zuoa");
            System.out.println(trie.search("zuoa"));
            System.out.println(trie.prefixNumber("zuo"));
        }
    }
}
