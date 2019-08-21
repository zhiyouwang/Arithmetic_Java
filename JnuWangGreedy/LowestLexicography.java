package com.JnuWangGreedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 最小字典序
 * 题目：有一个字符串数组，将所有字符串拼接在一起，使得拼成的最终的字符串按照字典序是最小的。
 * 这是典型的贪心算法的题，可以有很多的策略来进行字符串拼接，但不是所有的策略都是对的，要想验证贪心策略是否正确就将自己
 * 的策略与对数器进行测试来进行验证。
 * 这道题按照字典序排序有很多的策略，可以对每个字符串进行字典序比较，但是这样得到的字符串并不是最小字典序排序。
 * 例如：有两个字符串b，ba.目前由两种策略，1、分别比较。2、合并比较。
 * 进行比较后，很明显是第二种策略是正确的贪心策略，因为第一种策略得到的字符创是bba，第二种得到的是bab，因此第二种是正确
 * 的策略
 *
 * 贪心策略证明是否是正确的策略：
 * 1、是否具有传递性
 * 2、该情况下，任何打乱顺序的情况都会出现比它差的结果
 *
 * 本题是比较的策略，还有其它的一些方法的策略
 */
public class LowestLexicography {
    public static class MyComparator implements Comparator<String> {
        // 比较器，可以用来排序，两个参数a,b。若a - b < 0,则a在前面，若a - b > 0 ,则b在前
        // String类型可以使用compareTo来比较
        @Override
        public int compare(String a, String b) {
            return (a + b).compareTo(b + a);
        }
    }

    public static String lowestString(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs, new MyComparator());
        String res = "";
        for (int i = 0; i < strs.length; i++) {
            res += strs[i];
        }
        return res;
    }

    public static void main(String[] args) {
        String[] strs1 = { "jibw", "ji", "jp", "bw", "jibw" };
        System.out.println(lowestString(strs1));

        String[] strs2 = { "ba", "b" };
        System.out.println(lowestString(strs2));

    }
}
