package com.JnuWangPractice;

public class MaxGap {
    /**
     * 题目：给定一个数组，求如果排序之后，相邻两数的最大差值，要求时间复杂度O（N），且要求不能用基于比较的排序
     * 这题是桶排序的一个题目
     * 思路：数组有n个数，设定n + 1 个桶，将数组中的最大值放在最右边的桶，最小值放在最左边的桶，这样，分析可得，在n + 1
     * 个桶中，必然存在空桶。因此，最大差值必然存在于两个桶之间，不会存在于桶的内部。
     */

    public static int maxGap(int[] nums) {
        if (nums == null || nums.length < 2) return  0;
        int len = nums.length;
        // 全局最小值
        int min = Integer.MAX_VALUE;
        // 全局最大值
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (min == max) return 0;
        // 设置boolean类型的桶，标记桶里是否有值
        boolean[] hasNum = new boolean[len + 1];
        // 最大值桶，存储该桶中的最大值
        int[] maxs = new int[len + 1];
        // 最小值桶，存储该桶中的最小值
        int[] mins = new int[len + 1];
        // 存储数组元素应该在哪个桶的位置
        int bid = 0;
        // 跟新每个桶的最大值，最小值
        for (int i = 0; i < len; i++) {
            bid = bucket(nums[i], len, min, max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
            hasNum[bid] = true;
        }
        int result = 0;
        // 存储上一个桶的最大值
        int lastMax = maxs[0];
        for (int i = 1; i <= len; i++) {
            if (hasNum[i]) {
                result = Math.max(result, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return result;
    }

    /**
     * 求元素值应该放在哪个桶
     * @param num 数组元素
     * @param len 数组长度
     * @param min 数组最小值
     * @param max 数组最大值
     * @return
     */
    private static int bucket(long num, long len, long min, long max) {
        return (int)((num - min) * len / (max - min));
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,3,5,9,7,6,4,2,1};
        System.out.println(maxGap(nums));
    }
}
