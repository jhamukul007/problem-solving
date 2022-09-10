package com.array;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii
 * 122. Best Time to Buy and Sell Stock II
 */
public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int profit = 0;
        int len = prices.length;
        int buy = prices[0];
        for (int i = 1; i < len; i++) {
            int price = prices[i];
            if (price > buy) {
                profit += price - buy;
                buy = price;
            } else {
                buy = price;
            }
        }
        return profit;
    }
}
// Must Read before
// arr[] = {7 1 5 3 6 4};


// profit = 0 + 4 + 0 + 3 = 7

// 1 2 3 4 5


// 7 8 10

// 1) if array sorted by asc order, if we buy and sell at any price but total profit will be same.
// 2) Sorted by desc total profit = 0;
// 3) Now solve with zig zag

// 7 1 5 3 6 4

// ** Buy at 7 next element is lower, then sell on same price and profit will be 0.
// total = 0;
// ** Buy at 1 next element greater than 1 so we can sell ->
//     total = 4;
// ** Buy at 5 and sell at 5. total = 4
// ** by at 3 and sell at 6 total = 4 + 3 = 7
// ** By at 6 and sell at 6 total = 7
// ** By at 4 and sell at 4.
// total = 7

// 5 1 7
// Total = 6


