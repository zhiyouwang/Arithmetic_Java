package com.JnuWangGreedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 项目宣讲
 * 题目：一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目的宣讲。给你一每一个项目开始的时间和结束的时间（给你一
 * 个数组，里面是一个个具体的项目），你来安排宣讲的日程，要求会议室进行宣讲的场次最多。返回这个最多的宣讲次数。
 *
 * 思路：这题同样可以用贪心来找到最优解，最优的策略是按照项目的结束时间来进行操作，按最早结束的项目来进行宣讲，这样的宣
 * 讲次数是最多的
 */
public class BestArrange {
    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /**
     * 自定义比较器
     */
    public static class MyComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    /**
     * 求宣讲次数
     * @param programs
     * @param cur
     * @return
     */
    public static int bestArrange(Program[] programs, int cur) {
        Arrays.sort(programs, new MyComparator());
        int result = 0;
        for (int i = 0; i < programs.length; i++) {
            if (cur <= programs[i].start) {
                result++;
                cur = programs[i].end;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
