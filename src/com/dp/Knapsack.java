package com.dp;

import com.utils.Utils;

/**
 * * https://www.codingninjas.com/codestudio/problems/0-1-knapsack_920542
 * *
 */
public class Knapsack {

    /**
     * * Recursion
     * * Time : O(2^n)
     * * Space: O(n) -> stack space
     */
    public int maximumCollectedItemValueRecursive(int[] weights, int[] values, int capacity) {
        if (capacity == 0)
            return 0;
        return maximumCollectedItemValueRecursive(weights, values, capacity, weights.length - 1);
    }

    private int maximumCollectedItemValueRecursive(int[] weights, int[] values, int capacity, int index) {
        if (capacity == 0)
            return 0;
        if (index == 0) {
            if (weights[index] <= capacity)
                return values[index];
            else
                return 0;
        }
        int notPicked = maximumCollectedItemValueRecursive(weights, values, capacity, index - 1);
        int picked = Integer.MIN_VALUE;
        if (weights[index] <= capacity)
            picked = values[index] + maximumCollectedItemValueRecursive(weights, values, capacity - weights[index], index - 1);
        return Math.max(notPicked, picked);
    }

    /**
     * * Memorization
     * Time : O(n)
     * * Space : O(m*n) + O(n)
     */

    int knapsack(int[] weight, int[] value, int maxWeight) {

        if (maxWeight == 0) return 0;
        int[][] dp = new int[weight.length][maxWeight + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return maximumCollectedItemValueMemorization(weight, value, maxWeight, weight.length - 1, dp);
    }

    private int maximumCollectedItemValueMemorization(int[] weights, int[] values, int capacity, int index, int[][] dp) {
        if (capacity == 0)
            return 0;
        if (index == 0) {
            if (weights[index] <= capacity)
                return values[index];
            else
                return 0;
        }
        if (dp[index][capacity] != -1)
            return dp[index][capacity];
        int notPicked = maximumCollectedItemValueMemorization(weights, values, capacity, index - 1, dp);
        int picked = Integer.MIN_VALUE;
        if (weights[index] <= capacity)
            picked = values[index] + maximumCollectedItemValueMemorization(weights, values, capacity - weights[index], index - 1, dp);
        return dp[index][capacity] = Math.max(notPicked, picked);
    }

    /**
     * * DP
     * Time : O(n)
     * * Space : O(m*n)
     */
    int knapsackDP(int[] weight, int[] value, int n, int maxWeight) {

        if (n == 1) return weight[0] <= maxWeight ? value[0] : 0;
        int[][] dp = new int[n][maxWeight + 1];
        int row = dp.length, col = dp[0].length;
        for (int i = weight[0]; i < col; i++) {
            dp[0][i] = value[0];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                int notPicking = dp[i - 1][j];
                int picked = Integer.MIN_VALUE;
                if (weight[i] <= j)
                    picked = value[i] + dp[i - 1][j - weight[i]];
                dp[i][j] = Math.max(notPicking, picked);
            }
        }
        return dp[row - 1][col - 1];
    }

    /**
     * * DP
     * Time : O(n)
     * * Space : O(m*n)
     */
    int knapsackDPSpaceOptimized(int[] weight, int[] value, int n, int maxWeight) {

        if (n == 1) return weight[0] <= maxWeight ? value[0] : 0;

        int[] dp = new int[maxWeight + 1];
        int len = dp.length;
        for (int i = weight[0]; i < len; i++) {
            dp[i] = value[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = len-1; j >= 0; j--) {
                int notPick = dp[j];
                int picked = Integer.MIN_VALUE;
                if (weight[i] <= j)
                    picked = value[i] + dp[j - weight[i]];
                dp[j] = Math.max(notPick, picked);
            }
        }
        return dp[maxWeight];
    }


    public static void main(String[] args) {
        Knapsack obj = new Knapsack();
        int[] w1 = {1, 2, 9, 4};
        int[] v1 = {4, 6, 10, 3};
        int c1 = 4;

        int[] w2 = {1, 5, 9, 4};
        int[] v2 = {2, 6, 10, 3};
        int c2 = 4;

        Utils.printHeadLine("Recursion");
        System.out.println(obj.maximumCollectedItemValueRecursive(w1, v1, c1));
        System.out.println(obj.maximumCollectedItemValueRecursive(w2, v2, c2));


        Utils.printHeadLine("Memorization");
        System.out.println(obj.knapsack(w1, v1, c1));
        System.out.println(obj.knapsack(w2, v2, c2));


        Utils.printHeadLine("DP");
        System.out.println(obj.knapsackDP(w1, v1, w1.length, c1));
        System.out.println(obj.knapsackDP(w2, v2, w2.length, c2));

        Utils.printHeadLine("DP optimized");
        System.out.println(obj.knapsackDPSpaceOptimized(w1, v1, w1.length, c1));
        System.out.println(obj.knapsackDPSpaceOptimized(w2, v2, w2.length, c2));
    }
}
