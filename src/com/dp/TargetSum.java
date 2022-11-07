package com.dp;

/**
 * * https://www.codingninjas.com/codestudio/problems/target-sum_4127362
 * *Target Sum
 */
public class TargetSum {
    /**
     * * Recursion
     * @param n
     * @param target
     * @param arr
     * @return
     */
    public static int targetSum(int n, int target, int[] arr) {
        return targetSum(arr, n - 1, target);
    }

    private static int targetSum(int[] arr, int index, int target) {
        if (index == 0)
            return target - arr[0] == 0 ? 1: target + arr[0] == 0 ? 1: 0;
        int positive = targetSum(arr, index - 1, target - arr[index]);
        int negative = targetSum(arr, index - 1, target + arr[index]);
        return positive + negative;
    }

    /**
     * * Memorization
     * @param
     */

    public static int targetSumMemorization(int n, int target, int[] arr) {
        int[][] matrix = new int[n][target];
        return targetSum(arr, n - 1, target);
    }

    private static int targetSumMemorization(int[] arr, int index, int target) {
        if (index == 0)
            return target - arr[0] == 0 ? 1: target + arr[0] == 0 ? 1: 0;
        int positive = targetSum(arr, index - 1, target - arr[index]);
        int negative = targetSum(arr, index - 1, target + arr[index]);
        return positive + negative;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(targetSum(arr.length, target, arr));
    }
}
