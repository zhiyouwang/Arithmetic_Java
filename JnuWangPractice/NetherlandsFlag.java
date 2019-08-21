package com.JnuWangPractice;

public class NetherlandsFlag {

    /**
     * 荷兰国旗：给定一个值，要求该值左边的值全部比它小，右边的所有值都比它大
     * 这题的思想和快速排序的思想一样，进而可以引出改进的快速排序
     * @param arr
     * @param left
     * @param right
     * @param data 要比较的数值
     * @return
     */
    public static int[] partiton(int[] arr, int left, int right, int data) {
        int less = left - 1;
        int more = right + 1;
        while (left < more) {
            if (arr[left] < data) {
                swap(arr, ++less, left++);
            } else if (arr[left] > data) {
                swap(arr, --more, left);
            } else {
                left++;
            }
        }
        return new int[] {less + 1, more - 1};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
