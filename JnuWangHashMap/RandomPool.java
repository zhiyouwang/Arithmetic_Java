package com.JnuWangHashMap;

import java.util.HashMap;

/**
 * 设计一种结构，在该结构中有三种功能
 * insert（key）：将某个key加入到该结构，做到不重复加入。
 * delete（ket）：将原本在结构中的某个key移除。
 * getRandom（）：等概率随机返回结构中任何一个key。
 * 要求：三个方法的时间复杂度都是O（1）
 */
public class RandomPool {
    public static class Pool<K> {
        private HashMap<K, Integer> keyIndexMap;
        private HashMap<Integer, K> indexKeyMap;
        private int size;

        public Pool() {
            this.keyIndexMap = new HashMap<K, Integer>();
            this.indexKeyMap = new HashMap<Integer, K>();
            this.size = 0;
        }

        /**
         * 插入Key
         * @param key
         */
        public void insert(K key) {
            if (!keyIndexMap.containsKey(key)) {
                keyIndexMap.put(key, this.size);
                indexKeyMap.put(this.size++, key);
            }
        }

        /**
         * 删除Key
         * 注：按照正常思路来说，本来应该put两次，删除四次才对，但是删除的目的是为了进行后面的随机获取，而随机获取是在
         * indexKeyMap中进行的。HashMap的特点是如果是加入相同的key，就是覆盖值，index是唯一的，所以只用删除indexKeyMap
         * 中最后一个index即可
         * @param key
         */
        public void delete(K key) {
            if (keyIndexMap.containsKey(key)) {
                int lastIndex = --this.size;
                int deletIndex = this.keyIndexMap.get(key);
                K lastKey = this.indexKeyMap.get(lastIndex);
                this.keyIndexMap.put(lastKey, deletIndex);
                this.indexKeyMap.put(deletIndex, lastKey);
                this.keyIndexMap.remove(key);
                this.indexKeyMap.remove(lastIndex);
            }
        }

        /**
         * 随机获取一个Key
         * @return
         */
        public K getRandom() {
            if (this.size == 0) {
                return null;
            }
            int randomIndex = (int)(Math.random() * this.size);
            return this.indexKeyMap.get(randomIndex);
        }
        public static void main(String[] args) {
            Pool<String> pool = new Pool<String>();
            pool.insert("wang");
            pool.insert("zhi");
            pool.insert("you");
            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());
            System.out.println(pool.getRandom());
        }

    }
}
