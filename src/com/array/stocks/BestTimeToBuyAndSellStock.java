package com.array.stocks;

/**
 * * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * * 121. Best Time to Buy and Sell Stock
 */
public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buyPrice)
                buyPrice = prices[i];
            else
                maxProfit = Math.max(maxProfit, prices[i] - buyPrice);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,2,5,6,7};
        System.out.println(maxProfit(prices));
    }
}
