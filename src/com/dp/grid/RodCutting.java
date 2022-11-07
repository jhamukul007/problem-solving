package com.dp.grid;

import com.utils.Utils;

/**
 * * https://www.codingninjas.com/codestudio/problems/rod-cutting-problem_800284
 */
public class RodCutting {
    /**
     * * Recursion
     *
     * @param price
     * @param n
     * @return
     */
    public static int cutRod(int price[], int n) {
        return cutRod(price, price.length - 1, n);
    }

    public static int cutRod(int price[], int index, int n) {
        if (n == 0)
            return 0;
        if (index == 0)
            return n * price[0];
        int notPicked = cutRod(price, index - 1, n);
        int pick = Integer.MIN_VALUE;

        if (index + 1 <= n)
            pick = price[index] + cutRod(price, index, n - (index + 1));
        return Math.max(notPicked, pick);
    }

    /**
     * * Memorization
     *
     * @param price
     * @param n
     * @return
     */
    public static int cutRodMemorization(int price[], int n) {
        int[][] dp = new int[price.length][n + 1];
        return cutRodMemorization(price, price.length - 1, n, dp);
    }

    public static int cutRodMemorization(int price[], int index, int n, int[][] dp) {
        if (n == 0)
            return 0;
        if (index == 0)
            return n * price[0];
        if (dp[index][n] != 0)
            return dp[index][n];
        int notPicked = cutRodMemorization(price, index - 1, n, dp);
        int pick = Integer.MIN_VALUE;

        if (index + 1 <= n)
            pick = price[index] + cutRodMemorization(price, index, n - (index + 1), dp);
        return dp[index][n] = Math.max(notPicked, pick);
    }

    /**
     * * Tabulation
     *
     * @param price
     * @param n
     * @return
     */
    public static int cutRodDP(int price[], int n) {
        int[][] dp = new int[price.length][n + 1];
        for (int i = 1; i < n + 1; i++)
            dp[0][i] = i * price[0];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < n + 1; j++) {
                int notPicked = dp[i - 1][j];
                int picked = Integer.MIN_VALUE;
                if (i + 1 <= j)
                    picked = price[i] + dp[i][j - (i + 1)];
                dp[i][j] = Math.max(picked, notPicked);
            }
        }

        return dp[price.length-1][n];
    }

    /**
     * * Tabulation
     *
     * @param price
     * @param n
     * @return
     */
    public static int cutRodDpOptimized(int price[], int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++)
            dp[i] = i * price[0];

        for (int i = 1; i < price.length; i++) {
            for (int j = 1; j < n + 1; j++) {
                int notPicked = dp[j];
                int picked = Integer.MIN_VALUE;
                if (i + 1 <= j)
                    picked = price[i] + dp[j - (i + 1)];
                dp[j] = Math.max(picked, notPicked);
            }
        }

        return dp[n];
    }

    public static int cutRodDpOptimizedMin(int price[], int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++)
            dp[i] = i * price[0];

        for (int i = 1; i < price.length; i++) {
            for (int j = 1; j < n + 1; j++) {
                int notPicked = dp[j];
                int picked = Integer.MAX_VALUE;
                if (i + 1 <= j)
                    picked = price[i] + dp[j - (i + 1)];
                dp[j] = Math.min(picked, notPicked);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int[] price1 = {2, 5, 7, 8, 10};
        int n1 = 5;

        int[] price2 = {3, 5, 8, 9, 10, 17, 17, 20};
        int n2 = 8;

        int[] price3 = {3, 5, 6, 7, 10, 12};
        int n3 = 6;
//
//        Utils.printHeadLine("Recursion");
//        System.out.println(cutRod(price1, n1));
//        System.out.println(cutRod(price2, n2));
//        System.out.println(cutRod(price3, n3));
//
//
//        Utils.printHeadLine("Memorization");
//        System.out.println(cutRodMemorization(price1, n1));
//        System.out.println(cutRodMemorization(price2, n2));
//        System.out.println(cutRodMemorization(price3, n3));
//
//        Utils.printHeadLine("Tabulation");
//        System.out.println(cutRodDP(price1, n1));
//        System.out.println(cutRodDP(price2, n2));
//        System.out.println(cutRodDP(price3, n3));
//
//        Utils.printHeadLine("DP Space Optimized");
//        System.out.println(cutRodDpOptimized(price1, n1));
//        System.out.println(cutRodDpOptimized(price2, n2));
//        System.out.println(cutRodDpOptimized(price3, n3));


        int[] cuts = {5,6,1,4,2};
        System.out.println(cutRodDpOptimizedMin(cuts, 9));
    }
}
