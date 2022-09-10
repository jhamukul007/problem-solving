package com.dp;

/**
 * Question : https://www.codingninjas.com/codestudio/problems/maximum-sum-of-non-adjacent-elements_843261
 * https://leetcode.com/problems/house-robber/
 */
public class MaximumSumOfNonAdjacentElement {

    /**
     * Dynamic Programming
     * Time Complexity: O(n)
     * Space Complexity: O(n) -> Dp Array
     *
     * @param arr
     * @return
     */
    public int maximumSumOfNonAdjacentElement(int[] arr) {
        int len = arr.length;
        if (len == 1)
            return arr[0];

        int[] dp = new int[len];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 1], arr[i] + dp[i - 2]);
        }
        return dp[dp.length - 1];
    }

    /**
     * Dynamic Programming
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param arr
     * @return
     */
    public int maximumSumOfNonAdjacentElementOptimized(int[] arr) {
        if (arr.length == 1)
            return arr[0];
        int secLastMaxSum = arr[0];
        int lastMaxSum = Math.max(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            int current = Math.max(lastMaxSum, secLastMaxSum + arr[i]);
            secLastMaxSum = lastMaxSum;
            lastMaxSum = current;
        }
        return lastMaxSum;
    }

    /**
     * Recursion
     */
    public int maximumSumOfNonAdjacentElementRecursion(int[] arr) {
        return maximumSumOfNonAdjacentElementRecursion(arr, arr.length - 1);
    }

    public int maximumSumOfNonAdjacentElementRecursion(int[] arr, int index) {
        if (index == 0) return arr[index];
        if (index < 0) return 0;

        int indexTakenSum = arr[index] + maximumSumOfNonAdjacentElementRecursion(arr, index - 2);
        int indexNotTakenSum = 0 + maximumSumOfNonAdjacentElementRecursion(arr, index - 1);
        return Math.max(indexTakenSum, indexNotTakenSum);
    }

    /**
     * * Memorization
     * Time: O(n)
     * * Space : O(n) + O(n)
     * @param arr
     */
    public int maximumSumOfNonAdjacentMemorization(int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < dp.length; i++)
            dp[i] = -1;
        return maximumSumOfNonAdjacentMemorization(arr, dp, arr.length - 1);
    }

    public int maximumSumOfNonAdjacentMemorization(int[] arr, int[] dp, int index) {
        if (index == 0)
            return arr[index];
        if (index < 0)
            return 0;
        if (dp[index] != -1)
            return dp[index];
        int pickedElement = arr[index] + maximumSumOfNonAdjacentMemorization(arr, dp, index - 2);
        int nonPickedElement = 0 + maximumSumOfNonAdjacentMemorization(arr, dp, index - 1);
        return dp[index] = Math.max(pickedElement, nonPickedElement);
    }

    public static void main(String[] args) {
        MaximumSumOfNonAdjacentElement obj = new MaximumSumOfNonAdjacentElement();
        int[] arr = {4, 1, 2, 4};
        System.out.println("Dp : " + obj.maximumSumOfNonAdjacentElement(arr));
        System.out.println("Dp Optimized: " + obj.maximumSumOfNonAdjacentElementOptimized(arr));
        System.out.println("recursion: " + obj.maximumSumOfNonAdjacentElementRecursion(arr));
        System.out.println("Memorization: " + obj.maximumSumOfNonAdjacentMemorization(arr));
    }

}


