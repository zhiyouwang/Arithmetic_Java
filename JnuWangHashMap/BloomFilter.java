package com.JnuWangHashMap;

/**
 * 布隆过滤器：使用哈希表进行数据处理，简单来说，就是设计比特位的数组来节省空间。若这样设计，那么该比特数组就只要0或者1.
 * 布隆过滤器数组的设置大小与要过滤的字节数没有必然的联系，数组的长度设置只与样本量和失误率有关
 * m：比特 n：样本量 p：失误率
 * 布隆过滤器比特位：m = n * lnP / (ln2)**2 ---向上取整
 * 哈希函数的个数：k = ln2 * (m / n) ---向上取整
 * 真实失误率：(1 - e**(-(n * k) / m))**k
 */
public class BloomFilter {
    public static void main(String[] args) {
        // 定义1000长度的数组
        int[] arr = new int[1000];
        // 第30000个比特位
        int index = 30000;

        // 处于哪一个桶（即在数组的位置）
        int intIndex = index / 32;

        // 处于该桶的哪一个比特
        int bitIndex = index % 32;

        // 数组中该位置的值
        arr[intIndex] = (arr[intIndex] | (1 << bitIndex));
    }
}
