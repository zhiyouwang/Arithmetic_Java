package com.JnuWangPractice;

public class ArrayGenerator {

    /**
     * 对数器：在设计一个新的算法的时候，不能判断是否正确，有的OJ系统会给出测试用例来判断，但是算法出错的时候，并不能很
     * 清楚的知道哪个地方错了，或者测试案例的那个地方错了，因此可以自己随机产生数组，先写出一个最容易实现且完全正确的算
     * 法，和你设计的算法一起同时运行测试案列，如果大比例案例都正确的话，那么就认为该算法是正确的。
     */

    /**
     * 随机产生数组
     * @param maxSize 数组大小
     * @param maxValue 最大值
     * @return 数组
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int)((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((maxValue + 1) * Math.random() - (int)(maxValue * Math.random()));
        }
        return arr;
    }

    /**
     * 复制数组
     * @param arr
     * @return 数组
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) return null;
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i];
        }
        return  result;
    }

    /**
     * 判断两个数组元素是否相等
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) return false;
        if (arr1 == null && arr2 ==null) return true;
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

}
