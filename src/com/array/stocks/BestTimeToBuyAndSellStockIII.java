package com.array.stocks;

import com.utils.Utils;

import java.util.Arrays;

/**
 * * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * * 123. Best Time to Buy and Sell Stock III
 */
public class BestTimeToBuyAndSellStockIII {

    /**
     * * Recursion
     * Time Complexity:  O(2^n)
     * * Space Complexity : O(n)
     * @param prices
     * @return
     */
    public int maxProfitRecursion(int[] prices) {
        return maxProfitRecursion(prices, 0, true, 2);
    }

    public int maxProfitRecursion(int[] prices, int index, boolean isBuy, int remainingTransactions) {
        if(index == prices.length) return 0;
        if(remainingTransactions == 0) return 0;
        int profit;
        // Buying or not buying
        if (isBuy)
            profit = Math.max(-prices[index] + maxProfitRecursion(prices, index + 1, false, remainingTransactions),
                    maxProfitRecursion(prices, index + 1, true, remainingTransactions));
        else
            // Selling or not selling
            profit = Math.max(prices[index] + maxProfitRecursion(prices, index + 1, true, remainingTransactions - 1),
                    maxProfitRecursion(prices, index + 1, false, remainingTransactions));

        return profit;
    }


    /**
     * * Memorization
     * Time Complexity:  O(n)
     * * Space Complexity : O(n) + O(n * 2 * 2) ~ O(n) + O(n) ~ O(n)
     * @param prices
     * @return
     */
    public int maxProfitRecursionMemorization(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        for(int[][] dprows : dp) {
            for (int[] rows : dprows)
                // Adding higher number because the profit of transactions might reach -1 easily,
                // to avoid more recursive call adding a higher number.
                Arrays.fill(rows, -100000000);
        }
        return maxProfitRecursionMemorization(prices, 0, 1, 2, dp);
    }

    public int maxProfitRecursionMemorization(int[] prices, int index, int isBuy, int remainingTransactions, int[][][] dp) {
        if(index == prices.length) return 0;
        if(remainingTransactions == 0) return 0;

        if(dp[index][isBuy][remainingTransactions] != -100000000)
            return dp[index][isBuy][remainingTransactions];
        int profit;
        if (isBuy == 1)
            profit = Math.max(-prices[index] + maxProfitRecursionMemorization(prices, index + 1, 0, remainingTransactions, dp),
                    maxProfitRecursionMemorization(prices, index + 1, 1, remainingTransactions, dp));
        else
            profit = Math.max(prices[index] + maxProfitRecursionMemorization(prices, index + 1, 1,
                            remainingTransactions - 1, dp),
                    maxProfitRecursionMemorization(prices, index + 1, 0, remainingTransactions, dp));

        return dp[index][isBuy][remainingTransactions] = profit;
    }

    /**
     * * Dynamic Programming
     * Time Complexity:  O(n*2*2) ~ O(n)
     * * Space Complexity : O(n * 2 * 2) ~ O(n)
     * @param prices
     * @return
     */
    public int maxProfitDP(int[] prices) {
        int[][][] dp = new int[prices.length+1][2][3];
        int n = prices.length;
        for(int i = n - 1; i >= 0; i--){
            for(int j = 0; j < 2; j++){
                for(int k = 1; k < 3; k++){
                    // Sell case
                    int profit;
                    if(j == 1)
                        profit = Math.max(-prices[i] + dp[i+1][0][k], dp[i+1][1][k]);
                    else
                        profit = Math.max(prices[i] + dp[i+1][1][k-1], dp[i+1][0][k]);
                    dp[i][j][k] = profit;
                }
            }
        }
        return dp[0][1][2];
    }


    /**
     * * Memorization
     * Time Complexity:  O(n*2*2) ~ O(n)
     * * Space Complexity : O(2*3) ~ O(k)
     * @param prices
     * @return
     */
    public int maxProfitDPOptimizied(int[] prices) {
        int[][] prev = new int[2][3];
        int[][] current = new int[2][3];

        int n = prices.length;
        for(int i = n - 1; i >= 0; i--){
            for(int j = 0; j < 2; j++){
                current[0][0] = 0;
                for(int k = 1; k < 3; k++){
                    int profit;
                    // buy case
                    if(j == 1)
                         profit = Math.max(-prices[i] + prev[0][k], prev[1][k]);
                    else
                        profit = Math.max(prices[i] + prev[1][k-1], prev[0][k]);
                    current[j][k] = profit;
                }
            }
            int[][] temp = prev;
            prev = current;
            current = temp;
        }
        return prev[1][2];
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIII obj = new BestTimeToBuyAndSellStockIII();
        int[] prices1 =  {3,3,5,0,0,3,1,4};
        int[] prices2 =  {1,2,3,4,5};
        int[] prices3 = {7,6,4,3,1};

        Utils.printHeadLine("Recursion");
        System.out.println(obj.maxProfitRecursion(prices1));
        System.out.println(obj.maxProfitRecursion(prices2));
        System.out.println(obj.maxProfitRecursion(prices3));

        Utils.printHeadLine("Memorization");
        System.out.println(obj.maxProfitRecursionMemorization(prices1));
        System.out.println(obj.maxProfitRecursionMemorization(prices2));
        System.out.println(obj.maxProfitRecursionMemorization(prices3));

        Utils.printHeadLine("Dynamic programming");
        System.out.println(obj.maxProfitDP(prices1));
        System.out.println(obj.maxProfitDP(prices2));
        System.out.println(obj.maxProfitDP(prices3));

        Utils.printHeadLine("Dynamic programming optimized");
        System.out.println(obj.maxProfitDPOptimizied(prices1));
        System.out.println(obj.maxProfitDPOptimizied(prices2));
        System.out.println(obj.maxProfitDPOptimizied(prices3));

    }

}
