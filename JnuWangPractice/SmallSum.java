package com.JnuWangPractice;

public class SmallSum {

    /**
     * 这题并没有运行出来
     */

    /**
     * 小和问题：给出一个数组，找出数组中的每个元素左边比它小的元素，最后并相加求总和
     * 例：数组nums[1,2,3]，1的小和为1，2的小和为2 + 1, 3的小和为3 + 2 + 1
     * 这道题可以运用归并排序的思想，在每次合并的时候进行计算。
     * @param arr
     * @return
     */
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) return 0;
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static int mergeSort(int[] arr, int left, int right) {
        if (left == right) return 0;
        int mid = (right - left) >> 1;
        //
        return mergeSort(arr, left, mid) + mergeSort(arr, mid + 1, right) + merge(arr, left, mid, right);
    }

    public static int merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = 0, p1 = left, p2 = mid + 1;
        int result = 0;
        while (p1 <= mid && p2 <= right) {
            result += arr[p1] < arr[p2] ? (right - p2 + 1) * arr[p1] : 0;
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while (p2 <= right) {
            temp[i++] = arr[p2++];
        }
        System.arraycopy(temp, 0, arr, left, temp.length);
        /*for (int j = 0; j < temp.length; j++) {
            arr[left + j] = temp[j];
        }*/
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4};
        System.out.println(smallSum(nums));
    }
}
