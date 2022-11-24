package com.array.stocks;

import com.utils.MatrixUtil;
import com.utils.Utils;

import java.util.Arrays;

/**
 * * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * * 122. Best Time to Buy and Sell Stock II
 */
public class BestTimeToBuyAndSellStockII {

    // coding ninja
    // https://www.codingninjas.com/codestudio/problems/stocks-are-profitable_893405

    /**
     * * Time Complexity: O(n)
     * * Space: O(1)
     * @param n
     * @param values
     * @return
     */
    public static long getMaximumProfit(int n, long[] values) {
        if (n <= 0) return 0;
        long totalProfit = 0;
        long buyPrice = values[0];

        for (long value : values) {
            if (value < buyPrice)
                buyPrice = value;
            else if (value > buyPrice) {
                totalProfit += value - buyPrice;
                buyPrice = value;
            }
        }
        return totalProfit;
    }

    // leetcode

    /**
     * * Time Complexity: O(n)
     * * Space: O(1)
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int totalProfit = 0;
        int buy = prices[0];
        for (int price : prices) {
            if (price > buy) {
                totalProfit += price - buy;
                buy = price;
            } else
                buy = price;
        }
        return totalProfit;
    }

    /**
     * * Recursion
     * Time : O(2^n)
     * * Space : O(n)
     *
     * @param prices
     * @return
     */
    public int maxProfitRecursion(int[] prices) {
        return maxProfitRecursion(prices, 0, true);
    }

    public int maxProfitRecursion(int[] prices, int index, boolean isBuy) {
        if (index >= prices.length)
            return 0;
        if (isBuy)
            return Math.max(-prices[index] + maxProfitRecursion(prices, index + 1, false),
                    maxProfitRecursion(prices, index + 1, true));
        else
            return Math.max(prices[index] + maxProfitRecursion(prices, index + 1, true), maxProfitRecursion(prices, index + 1, false));
    }

    /**
     * * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii
     * * 122. Best Time to Buy and Sell Stock II
     * * Memorization
     * * Time : O(n * 2) + O(n) ~ O(n)-> Stack space
     * * Time : O(n*2) ~ O(n)
     *
     * @param prices
     * @return
     */
    public int maxProfitMemorization(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int[] dpRow : dp)
            Arrays.fill(dpRow, -1);
        return getMaximumProfitMemorization(prices, 0, 1, dp);
    }

    public static int getMaximumProfitMemorization(int[] prices, int index, int isBuy, int[][] dp) {
        if (index == prices.length)
            return 0;
        if (dp[index][isBuy] != -1)
            return dp[index][isBuy];
        int profit = 0;
        if (isBuy == 1)
            profit = Math.max(-prices[index] + getMaximumProfitMemorization(prices, index + 1, 0, dp),
                    0 + getMaximumProfitMemorization(prices, index + 1, 1, dp));
        else
            profit = Math.max(prices[index] + getMaximumProfitMemorization(prices, index + 1, 1, dp), 0 + getMaximumProfitMemorization(prices, index + 1, 0, dp));

        return dp[index][isBuy] = profit;
    }

    /**
     * * Dynamic Programming
     * * Space : O(n * 2) ~ O(n)
     * * Time : O(n * 2) ~ O(n)
     *
     * @param prices
     * @return
     */
    public int maxProfitDP(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        dp[n][0] = dp[n][1] = 0;

        int profit;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < 2; j++) {
                if (j == 0)
                    profit = Math.max(prices[i] + dp[i + 1][1], dp[i + 1][0]);
                else
                    profit = Math.max(-prices[i] + dp[i + 1][0], dp[i + 1][1]);
                dp[i][j] = profit;
            }
        }
        return dp[0][1];
    }


    /**
     * * Dynamic Programming optimized
     * * Space : O(1)
     * * Time : O(n)
     *
     * @param prices
     * @return
     */
    public int maxProfitDPOptimizied(int[] prices) {
        int n = prices.length;
        int buyPrice = 0;
        int sellCost = 0;

        for (int i = n - 1; i >= 0; i--) {
            sellCost = Math.max(prices[i] + buyPrice, sellCost);
            buyPrice = Math.max(-prices[i] + sellCost, buyPrice);
        }
        return buyPrice;
    }

}
