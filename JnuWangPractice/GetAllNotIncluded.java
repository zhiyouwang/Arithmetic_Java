package com.JnuWangPractice;

import java.util.ArrayList;
import java.util.List;

public class GetAllNotIncluded {

    public static List<Integer> getAllNotInclude(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        // 在nums1数组中查找是否包含nums2的元素
        for (int i = 0; i < nums2.length; i++) {
            int left = 0;
            int right = nums1.length - 1;
            boolean contains = false;
            // left和right都是nums1的指针
            while (left <= right) {
                int mid = (right + left) >> 1;
                if (nums1[mid] == nums2[i]) {
                    contains = true;
                    break;
                }
                if (nums1[mid] > nums2[i]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (!contains) {
                result.add(nums2[i]);
            }
        }
        return  result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {1,2,3,5};
        int[] nums2 = new int[] {2,5,7};
        //List<Integer> list = new ArrayList<>();
        List<Integer> list = getAllNotInclude(nums1, nums2);
        for (int i: list
             ) {
            System.out.print(i + " ");
        }
    }
}
