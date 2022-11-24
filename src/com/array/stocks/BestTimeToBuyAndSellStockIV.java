package com.array.stocks;

import com.utils.Utils;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockIV {

    public int maxProfit(int k, int[] prices) {
        return maxProfit(prices, 0, 1, k);
    }

    public int maxProfit(int[] prices, int index, int isBuy, int k) {
        if (index == prices.length)
            return 0;
        if (k == 0) return 0;
        int profit;
        if (isBuy == 1)
            profit = Math.max(-prices[index] + maxProfit(prices, index + 1, 0, k),
                    maxProfit(prices, index + 1, 1, k));
        else
            profit = Math.max(prices[index] + maxProfit(prices, index + 1, 1, k - 1),
                    maxProfit(prices, index + 1, 0, k));
        return profit;
    }

    /**
     * * Memorization
     * * Time : O(n)
     * * Space: O(n) + O(n *2 *(k+1)) ~ O(n) + O(n*k)
     *
     * @param k
     * @param prices
     * @return
     */
    public int maxProfitMemorization(int k, int[] prices) {
        int[][][] dp = new int[prices.length][2][k + 1];
        for (int[][] dpRows : dp) {
            for (int[] rows : dpRows) {
                Arrays.fill(rows, -10000000);
            }
        }

        return maxProfitMemorization(prices, 0, 1, k, dp);

    }

    public int maxProfitMemorization(int[] prices, int index, int buy, int k, int[][][] dp) {
        if (index == prices.length)
            return 0;
        if (k == 0) return 0;
        int profit;
        if (dp[index][buy][k] != -10000000)
            return dp[index][buy][k];
        if (buy == 1)
            profit = Math.max(-prices[index] + maxProfitMemorization(prices, index + 1, 0, k, dp), maxProfitMemorization(prices, index + 1, 1, k, dp));
        else
            profit = Math.max(prices[index] + maxProfitMemorization(prices, index + 1, 1, k - 1, dp), maxProfitMemorization(prices, index + 1, 0, k, dp));
        return dp[index][buy][k] = profit;
    }

    /**
     * * Dynamic Programming
     * * Time Complexity: O(m * 2 * k) ~ O(m*k)
     * * Space : O(m * 2 * k) ~ O(m * k)
     * @param k
     * @param prices
     * @return
     */
    public int maxProfitDP(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][k + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                for (int l = 1; l <= k; l++) {
                    int profit = 0;

                    // Buy Stocks
                    if (j == 1)
                        profit = Math.max(-prices[i] + dp[i + 1][0][l], dp[i + 1][1][l]);
                    else
                        profit = Math.max(prices[i] + dp[i + 1][1][l - 1], dp[i + 1][0][l]);
                    dp[i][j][l] = profit;
                }
            }
        }
        return dp[0][1][k];
    }

    /**
     * * Dynamic Programming space optimized
     * * Time: O(n * 2 * k) ~ O(nk)
     * * Space : O(2 * k) ~ O(k)
     * @param k
     * @param prices
     * @return
     */
    public int maxProfitDpOptimized(int k, int[] prices) {
        int[][] prev = new int[2][k + 1];
        int[][] cur = new int[2][k + 1];
        int n = prices.length;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                for (int l = 1; l <= k; l++) {
                    int profit = 0;

                    // Buy Stocks
                    if (j == 1)
                        profit = Math.max(-prices[i] + prev[0][l], prev[1][l]);
                    else
                        profit = Math.max(prices[i] + prev[1][l - 1], prev[0][l]);
                    cur[j][l] = profit;
                }
            }
            int[][] temp = prev;
            prev = cur;
            cur = temp;
        }
        return prev[1][k];
    }


    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIV obj = new BestTimeToBuyAndSellStockIV();
        int[] prices = {2, 4, 1};
        int k = 2;
        int[] prices1 = {3, 2, 6, 5, 0, 3};
        int k1 = 2;
        Utils.printHeadLine("Recursion");
        System.out.println(obj.maxProfit(k, prices));
        System.out.println(obj.maxProfit(k1, prices1));

        Utils.printHeadLine("Memorization");
        System.out.println(obj.maxProfitMemorization(k, prices));
        System.out.println(obj.maxProfitMemorization(k1, prices1));


        Utils.printHeadLine("Dynamic Programming");
        System.out.println(obj.maxProfitDP(k, prices));
        System.out.println(obj.maxProfitDP(k1, prices1));

        Utils.printHeadLine("Dynamic Programming Space optimized");
        System.out.println(obj.maxProfitDpOptimized(k, prices));
        System.out.println(obj.maxProfitDpOptimized(k1, prices1));
    }
}
