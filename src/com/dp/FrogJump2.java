package com.dp;

import com.utils.Utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * https://www.youtube.com/watch?v=Kmh3rhyEtB8&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=5
 * https://atcoder.jp/contests/dp/tasks/dp_b
 */
public class FrogJump2 {

    public static int minCostForKJump(int[] cost, int k) {
        return minCostForKJump(cost, k, 0, 0, 0);
    }

    public static int minCostForKJump(int[] cost, int k, int fromPos, int toPos, int totalCost) {
        if (toPos >= cost.length)
            return totalCost;
        totalCost += Math.abs(cost[toPos] - cost[fromPos]);
        for (int i = fromPos; i <= fromPos + k && i < cost.length; i++) {
            totalCost = minCostForKJump(cost, k, fromPos, i, totalCost);
        }
        return totalCost;
    }

    /**
     * Dynamic Programming
     * Time Complexity: O(n*k)
     * Space: O(n)
     *
     * @param cost
     * @param k
     * @return
     */
    public static int minCostForKJumpDP(int[] cost, int k) {
        int[] dp = new int[cost.length];
        for (int i = 0; i < dp.length; i++)
            dp[i] = Integer.MAX_VALUE;

        dp[0] = 0;
        dp[1] = Math.abs(cost[1] - cost[0]);

        for (int i = 2; i < cost.length; i++) {
            int minCost = Integer.MAX_VALUE;
            int j = i - k < 0 ? 0 : i - k;
            for (; j < i && j >= 0; j++) {
                int costAmount = Math.abs(cost[i] - cost[j]) + dp[j];
                minCost = Math.min(minCost, costAmount);
            }
            dp[i] = minCost;
        }
        return dp[dp.length - 1];
    }

    /**
     * Dynamic Programming Optimized
     * Time Complexity: O(n*k)
     * Space: O(K)
     *
     * @param cost
     * @param k
     * @return
     */
    public static int minCostForKJumpDPOptimsation(int[] cost, int k) {
        List<Integer> kthCost = new ArrayList<>(k);
        kthCost.add(0);
        for (int i = 1; i < cost.length; i++) {
            int minCost = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int totalCost = Math.abs(cost[i] - cost[i - j]) + kthCost.get(i - j);
                    minCost = Math.min(minCost, totalCost);
                    if (kthCost.size() >= k)
                        kthCost.remove(0);
                    kthCost.add(minCost);
                }
            }
        }
        return kthCost.get(kthCost.size() - 1);
    }


    public static void main(String[] args) {
//        int[] cost = {10,20,10};
//        int k = 1;
        int[] cost1 = {40, 10, 20, 70, 80, 10, 20, 70, 80, 60};
        int k1 = 4;
        Utils.print(minCostForKJumpDP(cost1, k1));
        Utils.print(minCostForKJumpDPOptimsation(cost1, k1));
    }
}
